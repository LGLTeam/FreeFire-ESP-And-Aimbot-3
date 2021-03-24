#pragma once

#define _USE_MATH_DEFINES
#include <math.h>
#include <cstring>

struct Rect
{
    union
    {
        struct
        {
			float m_XMin;
			float m_YMin;
			float m_Width;
			float m_Height;
        };
        float data[4];
    };

    inline Rect();
    inline Rect(float XMin, float YMin, float Width, float Height);
};

Rect::Rect() : m_XMin(0), m_YMin(0), m_Width(0), m_Height(0) {}
Rect::Rect(float XMin, float YMin, float Width, float Height) : m_XMin(XMin), m_YMin(YMin), m_Width(Width), m_Height(Height) {}

