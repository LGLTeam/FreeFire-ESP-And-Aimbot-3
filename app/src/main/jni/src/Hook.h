#ifndef ANDROID_MOD_MENU_HOOK_H
#define ANDROID_MOD_MENU_HOOK_H
#include <src/Unity/Vector3.hpp>
#include <src/Unity/Quaternion.hpp>
#include <src/Unity/Vector2.hpp>
#include "Global.h"
using namespace std;

class Vvector3 {
public:
    float X;
    float Y;
    float Z;
    Vvector3() : X(0), Y(0), Z(0) {}
    Vvector3(float x1, float y1, float z1) : X(x1), Y(y1), Z(z1) {}
    Vvector3(const Vvector3 &v);
    ~Vvector3();
};
Vvector3::Vvector3(const Vvector3 &v) : X(v.X), Y(v.Y), Z(v.Z) {}
Vvector3::~Vvector3() {}

bool (*IsSameTeam)(void *_this, void* p1, void* p2) = (bool(*)(void *, void*, void*))getRealOffset(Global.IsSameTeam);

void* (*getPlayerByIndex)(void* match, uint8_t index) = (void*(*)(void *, uint8_t))getRealOffset(Global.Player_Index);

bool (*AttackableEntity_GetIsDead)(void *attackableEntity) = (bool (*)(void *))getRealOffset(Global.AttackableEntity_GetIsDead);

bool (*AttackableEntity_IsVisible)(void *attackableEntity) = (bool (*)(void *))getRealOffset(Global.AttackableEntity_IsVisible);

static bool get_AttackableEntity_GetIsDead(void *player) {
    bool (*_get_AttackableEntity_GetIsDead)(void *players) = (bool (*)(void *))getRealOffset(Global.AttackableEntity_GetIsDead);
    return _get_AttackableEntity_GetIsDead(player);
	}


static bool get_AttackableEntity_IsVisible(void *player) {
    bool (*_get_AttackableEntity_IsVisible)(void *players) = (bool (*)(void *))getRealOffset(Global.AttackableEntity_IsVisible);
    return _get_AttackableEntity_IsVisible(player);
	}

static void *get_MyFollowCamera(void *players) {
    void *(*_get_MyFollowCamera) (void *player) = (void *(*)(void *))getRealOffset(Global.get_MyFollowCamera);
    return _get_MyFollowCamera(players);
}

static void *Curent_Match() {
    void *(*_Curent_Match) (void *nuls) = (void *(*)(void *))getRealOffset(Global.Curent_Match);
    return _Curent_Match(NULL);
}

static monoString *U3DStr(const char *str) {
    monoString *(*String_CreateString)(void *_this, const char *str) = (monoString * (*)(void *, const char *))getRealOffset(Global.U3DStr);
    return String_CreateString(NULL, str);
}

static monoString *FormatCount(int enemy, int bot) {
    char buf[128] = {0};
    sprintf(buf, "[Enimigos:%d Bots:%d]", enemy, bot);
    return U3DStr(buf);
}

static bool IsFiring(void *player) {
    bool (*_IsFiring)(void *players) = (bool (*)(void *))getRealOffset(Global.IsFiring);
    return _IsFiring(player);
}

static void spofNick(void *players) {
    void (*_spof_nick)(void *player, monoString *nick) = (void (*)(void *, monoString *))getRealOffset(Global.spof_nick);
    _spof_nick(players, U3DStr("VITINHO MODZ"));
}

static monoString *U3DStrFormat(float distance) {
    char buffer[128] = {0};
    sprintf(buffer, " [metros: %.f ]", distance);
    return U3DStr(buffer);
}

static void *CurrentUIScene() {
    void *(*_CurrentUIScene)(void *nuls) = (void *(*)(void *))getRealOffset(Global.CurrentUIScene);
    return _CurrentUIScene(NULL);
}

static monoString* get_NickName(void *player) {
    monoString* (*_get_NickName)(void *players) = (monoString * (*)(void *))getRealOffset(Global.get_NickName);
    return _get_NickName(player);
}

static void AddTeammateHud(void *player, monoString *nick, monoString *grup) {
    void (*_AddTeammateHud)(void *players, monoString * nicks, monoString * nickss) = (void (*)(void *, monoString *, monoString *))getRealOffset(Global.AddTeammateHud);
    void *ui = CurrentUIScene();
    if (ui != NULL) {
        _AddTeammateHud(player, nick, grup);
    }
}

static void *get_imo(void *player) {
    void *(*_get_imo)(void *players) = (void *(*)(void *))getRealOffset(Global.get_imo);
    return _get_imo(player);
}


static void set_esp(void *imo, Vector3 x, Vector3 y) {
    void (*_set_esp)(void *imo, Vector3 X, Vector3 Y) = (void (*)(void *, Vector3, Vector3))getRealOffset(Global.set_esp);
    _set_esp(imo, x, y);
}

static bool get_IsSighting(void *player) {
    bool (*_get_IsSighting)(void *players) = (bool (*)(void *))getRealOffset(Global.get_IsSighting);
    return _get_IsSighting(player);
}

static bool get_IsCrouching(void *player) {
    bool (*_get_IsCrouching)(void *players) = (bool (*)(void *))getRealOffset(Global.get_IsCrouching);
    return _get_IsCrouching(player);
}

static Vector3 Transform_INTERNAL_GetPosition(void *player) {
    Vector3 out = Vector3::Zero();
    void (*_Transform_INTERNAL_GetPosition)(void *transform, Vector3 * out) = (void (*)(void *, Vector3 *))getRealOffset(Global.Transform_INTERNAL_GetPosition);
    _Transform_INTERNAL_GetPosition(player, &out);
    return out;
}

static void *Current_Local_Player() {
    void *(*_Local_Player)(void *players) = (void *(*)(void *))getRealOffset(Global.Current_Local_Player);
    return _Local_Player(NULL);
}

static void *GetLocalPlayerOrObServer() {
    void *(*_GetLocalPlayerOrObServer)(void *players) = (void *(*)(void *))getRealOffset(Global.GetLocalPlayerOrObServer);
    return _GetLocalPlayerOrObServer(NULL);
}

static void *Component_GetTransform(void *player) {
    void *(*_Component_GetTransform)(void *component) = (void *(*)(void *))getRealOffset(Global.Component_GetTransform);
    return _Component_GetTransform(player);
}

static bool get_isAlive(void *player) {
    bool (*_get_isAlive)(void *players) = (bool (*)(void *))getRealOffset(Global.get_isAlive);
    return _get_isAlive(player);
}

static bool get_isLocalTeam(void *player) {
    bool (*_get_isLocalTeam)(void *players) = (bool (*)(void *))getRealOffset(Global.get_isLocalTeam);
    return _get_isLocalTeam(player);
}

static bool get_isVisible(void *player) {
    bool (*_get_isVisible)(void *players) = (bool (*)(void *))getRealOffset(Global.get_isVisible);
    return _get_isVisible(player);
}




static Vector3 GetAttackableCenterWS(void *player) {
    Vector3 (*_GetAttackableCenterWS)(void *players) = (Vector3 (*)(void *))getRealOffset(Global.GetAttackableCenterWS);
    return _GetAttackableCenterWS(player);
}

static int GetPhysXPose(void *player) {
    int (*_GetPhysXPose)(void *players) = (int (*)(void *))getRealOffset(Global.GetPhysXPose);
    return _GetPhysXPose(player);
}

static Vector3 GetForward(void *player) {
    Vector3 (*_GetForward)(void *players) = (Vector3 (*)(void *))getRealOffset(Global.GetForward);
    return _GetForward(player);
}

static void set_aim(void *player, Quaternion look) {
    void (*_set_aim)(void *players, Quaternion lock) = (void (*)(void *, Quaternion))getRealOffset(Global.set_aim);
    _set_aim(player, look);
}

static void ShowDynamicPopupMessage(monoString *nick) {
    void (*_ShowDynamicPopupMessage)(void *players, monoString * nicks, float duration) = (void (*)(void *, monoString *, float))getRealOffset(Global.ShowDynamicPopupMessage);
    void *ui = CurrentUIScene();
    if (ui != NULL) {
        _ShowDynamicPopupMessage(ui, nick, 0.1f);
    }
}

static void Transform_INTERNAL_SetPosition(void *player, Vvector3 inn) {
    void (*_Transform_INTERNAL_SetPosition)(void *transform, Vvector3 in) = (void (*)(void *, Vvector3))getRealOffset(Global.Transform_INTERNAL_SetPosition);
    _Transform_INTERNAL_SetPosition(player, inn);
}

static void *Camera_main() {
    void *(*_Camera_main)(void *nuls) = (void *(*)(void *))getRealOffset(Global.Camera_main);
    return _Camera_main(NULL);
}

static void ShowPopupMessages(monoString *nick) {
    void (*_ShowPopupMessage)(void *players, monoString * nicks, float duration) = (void (*)(void *, monoString *, float))getRealOffset(Global.ShowPopupMessage);
    void *ui = CurrentUIScene();
    if (ui != NULL) {
        _ShowPopupMessage(ui, nick, 0.1f);
    }
}

#endif

