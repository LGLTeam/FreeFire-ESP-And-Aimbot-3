#ifndef ESP_H
#define ESP_H

#include <jni.h>


class ESP {
private:
    JNIEnv *_env;
    jobject _cvsView;
    jobject _cvs;

public:
    ESP() {
        _env = nullptr;
        _cvsView = nullptr;
        _cvs = nullptr;
    }

    ESP(JNIEnv *env, jobject cvsView, jobject cvs) {
        this->_env = env;
        this->_cvsView = cvsView;
        this->_cvs = cvs;
    }

    bool isValid() const {
        return (_env != nullptr && _cvsView != nullptr && _cvs != nullptr);
    }

    int getWidth() const {
        if (isValid()) {
            jclass canvas = _env->GetObjectClass(_cvs);
            jmethodID width = _env->GetMethodID(canvas, "getWidth", "()I");
            return _env->CallIntMethod(_cvs, width);
        }
        return 0;
    }

    int getHeight() const {
        if (isValid()) {
            jclass canvas = _env->GetObjectClass(_cvs);
            jmethodID width = _env->GetMethodID(canvas, "getHeight", "()I");
            return _env->CallIntMethod(_cvs, width);
        }
        return 0;
    }

    void DrawLine(Color color, float thickness, Vector3 start, Vector3 end) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawline = _env->GetMethodID(canvasView, "DrawLine",
                                                   "(Landroid/graphics/Canvas;IIIIFFFFF)V");
            _env->CallVoidMethod(_cvsView, drawline, _cvs, (int) color.A, (int) color.R,
                                 (int) color.G, (int) color.B,
                                 thickness,
                                 start.X, start.Y, end.X, end.Y);
        }
    }

    void DrawText(Color color, const char *txt, Vector3 pos, float size) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawtext = _env->GetMethodID(canvasView, "DrawText",
                                                   "(Landroid/graphics/Canvas;IIIILjava/lang/String;FFF)V");
            _env->CallVoidMethod(_cvsView, drawtext, _cvs, (int) color.A, (int) color.R,
                                 (int) color.G, (int) color.B,
                                 _env->NewStringUTF(txt), pos.X, pos.Y, size);
        }
    }

    void DrawFilledCircle(Color color, Vector3 pos, float radius) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawfilledcircle = _env->GetMethodID(canvasView, "DrawFilledCircle",
                                                           "(Landroid/graphics/Canvas;IIIIFFF)V");
            _env->CallVoidMethod(_cvsView, drawfilledcircle, _cvs, (int) color.A, (int) color.R,
                                 (int) color.G, (int) color.B, pos.X, pos.Y, radius);
        }
    }

    void DrawBox(Color color, float stroke, Rect rect) {
        Vector3 v1 = Vector3(rect.m_XMin, rect.m_YMin);
        Vector3 v2 = Vector3(rect.m_XMin + rect.m_Width, rect.m_YMin);
        Vector3 v3 = Vector3(rect.m_XMin + rect.m_Width, rect.m_YMin + rect.m_Height);
        Vector3 v4 = Vector3(rect.m_XMin, rect.m_YMin + rect.m_Height);

        DrawLine(color, stroke, v1, v2); // ALINHAR
        DrawLine(color, stroke, v2, v3); // LINHA DIREITA
        DrawLine(color, stroke, v3, v4); // LINHA ABAIXO
        DrawLine(color, stroke, v4, v1); // LINHA ESQUERDA
    }


    void DrawHorizontalHealthBar(Vector3 screenPos, float width, float maxHealth, float currentHealth) {
        screenPos -= Vector3(0.0f, 8.0f);
        DrawBox(Color(0, 0, 0, 255), 3, Rect(screenPos.X, screenPos.Y, width + 2, 5.0f));
        screenPos += Vector3(1.0f, 1.0f);
        Color clr = Color(0, 255, 0, 255);
        float hpWidth = (currentHealth * width) / maxHealth;
        if (currentHealth <= (maxHealth * 0.6)) {
            clr = Color(255, 255, 0, 255);
        }
        if (currentHealth < (maxHealth * 0.3)) {
            clr = Color(255, 0, 0, 255);
        }
        DrawBox(clr, 3, Rect(screenPos.X, screenPos.Y, hpWidth, 3.0f));
    }

    void DrawCrosshair(Color clr, Vector3 center, float size = 20) {
        float x = center.X - (size / 2.0f);
        float y = center.Y - (size / 2.0f);
        DrawLine(clr, 1, Vector3(x, center.Y), Vector3(x + size, center.Y));
        DrawLine(clr, 1, Vector3(center.X, y), Vector3(center.X, y + size));
    }
};

#endif
