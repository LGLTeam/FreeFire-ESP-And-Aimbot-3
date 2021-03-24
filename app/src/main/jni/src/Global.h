#ifndef ANDROID_MOD_MENU_GLOBAL_H
#define ANDROID_MOD_MENU_GLOBAL_H

struct {

    uintptr_t MainCameraTransform = 0x50;  // public Transform MainCameraTransform; // 0x50  (1.54.2)
	uintptr_t Dictionary = 0x44; // protected Dictionary<byte, Player> b]T^b|Q; // 0x44  (1.54.2)
	uintptr_t HeadTF = 0x1A4; // protected Transform s^uN~t; // 0x1A4  (1.54.2)
	uintptr_t HipTF = 0x1A8; // protected Transform sqdz[Xb; // 0x1A8  (1.54.2)
	uintptr_t HandTF = 0x1A0; // protected Transform {vps^o; // 0x1A0  (1.54.2)
	uintptr_t EyeTF = 0x1AC; // protected Transform mB]ByDk; // 0x1AC  (1.54.2)
	uintptr_t ToeTF = 0x1B4; // protected Transform hFLM]|b; // 0x1B4  (1.54.2)
	uintptr_t RightShoulder = 0x1D4; // protected Transform OjNRJt; // 0x1D4  (1.54.2)
	uintptr_t LeftShoulder = 0x1D0; // protected Transform mcbhyOv; // 0x1D0  (1.54.2)
    uintptr_t IsClientBot = 0xC4; // public bool IsClientBot; // 0xC4  (1.54.2)
	uintptr_t U3DStr = 0x228396C; // 1.54.2
    uintptr_t U3DStrConcat = 0x228210C; // 1.54.2
    uintptr_t Component_GetTransform = 0x2729DC4; // public Transform get_transform() 1.54.2 
    uintptr_t GetCameraTrackableEntityTransfrom = 0xA37568; // public Transform GetCameraTrackableEntityTransfrom 1.54.2
    uintptr_t Transform_INTERNAL_GetPosition = 0x2D3638C; // private void INTERNAL_get_position 1.54.2
    uintptr_t Transform_INTERNAL_SetPosition = 0x2D3644C; // private void INTERNAL_set_position 1.54.2
    uintptr_t GetForward = 0x2D36A70; // public Vector3 get_forward 1.54.2
    uintptr_t get_isAlive = 0xA37650; // public bool IsCameraTrackableEntityAlive 1.54.2 
    uintptr_t GetPhysXPose = 0xA5B828; // public xl^LGZc GetPhysXPose 1.54.2
    uintptr_t IsFiring = 0xA6DBFC; // public bool IsFiring 1.54.2
    uintptr_t IsCrouching = 0xA5B85C; // public bool IsCrouching 1.54.2
    uintptr_t get_IsSighting = 0xAA1964; // public bool get_IsSighting 1.54.2
    uintptr_t get_IsReallyDead = 0xA521B0; // public bool get_IsReallyDead 1.54.2
    uintptr_t get_isLocalPlayer = 0xA54178; // public bool IsLocalPlayer 1.54.2
    uintptr_t get_isLocalTeam = 0xA59E10; // public virtual bool IsLocalTeammate 1.54.2
    uintptr_t get_isVisible = 0xA53758; // public override bool IsVisible 1.54.2
    uintptr_t set_aim = 0xA51D64; // public void SetAimRotation 1.54.2
    uintptr_t Camera_main_fov = 0x2722EFC; // public float get_fieldOfView 1.54.2
    uintptr_t get_imo = 0xA3DB18; // public FPnavhE GetActiveWeapon 1.54.2
    uintptr_t set_esp = 0xF482E0; //	public void fxZep 1.54.2
    uintptr_t GetAttackableCenterWS = 0xA50948; // public override Vector3 GetAttackableCenterWS 1.54.2
    uintptr_t GetCharacterControllerTopPosition = 0xA8DACC; // public virtual Vector3 GetCharacterControllerTopPosition 1.54.2
    uintptr_t get_NickName = 0xA35B00; // public string get_NickName 1.54.2
    uintptr_t WorldToScreenPoint = 0x2724AA0; // public Vector3 WorldToScreenPoint 1.54.2
    uintptr_t get_height = 0x2B8B43C; // public static int get_height 1.54.2
    uintptr_t get_width = 0x2B8B3AC; // public static int get_width 1.54.2
    uintptr_t get_deltaTime = 0x2D34E34; // public static float get_fixedDeltaTime 1.54.2
    uintptr_t CurrentUIScene = 0x1FAAFDC; // public static UICOWBaseScene CurrentUIScene 1.54.2
    uintptr_t Curent_Match = 0x1FBEDF8; // public static Th|G[l[ CurrentMatch 1.54.2
    uintptr_t Current_Local_Player = 0x1FBF14C; // public static Player CurrentLocalPlayer 1.54.2
    uintptr_t GetLocalPlayerOrObServer = 0x1FC03F0; // public static Player GetLocalPlayerOrObServer 1.54.2
    uintptr_t CurrentLocalSpectator = 0x1FBF5CC; // public static olfyRLw CurrentLocalSpectator() 1.54.2
    uintptr_t Player_Index = 0x1597968; // public Player ]xBnHak(byte WMRg}) { } 1.54.2
    uintptr_t AddTeammateHud = 0x135E088; //	public void ShowAssistantText(string playerName, string line) { } 1.54.2
    uintptr_t spof_uid = 0xA50D68; // protected void kjkIWoo(ulong aKRQdu) { } 1.54.2
    uintptr_t spof_nick = 0xA50E58; // protected void rhTOWJa(string aKRQdu) { } 1.54.2
    uintptr_t ShowDynamicPopupMessage = 0x134BBA0; // public void ShowDynamicPopupMessage(string message, float duration = 5) { } 1.54.2
    uintptr_t ShowPopupMessage = 0x134BD28; //	public void ShowPopupMessage(string message, float duration = 2) { } 1.54.2
    uintptr_t GetLocalPlayer = 0x28FC52C; // private static Player GetLocalPlayer() { } 1.54.2
    uintptr_t GetCharacterHeight = 0xA62404; // public float GetCharacterHeight() 1.54.2
    uintptr_t set_height = 0x27286D0; // public void set_height(float value) { } 1.54.2
    uintptr_t get_CharacterController = 0xA511B4; // public CharacterController get_CharacterController() 1.54.2
    uintptr_t IsUserControlChanged = 0xA5B740; // public bool IsUserControlChanged() 1.54.2
    uintptr_t set_invitee_nickname = 0x2A799E0; // public void set_invitee_nickname(string value) { } 1.54.2
    uintptr_t Raycast = 0x2A7367C; // public static bool Raycast(Vector3 origin, Vector3 direction, float maxDistance, int layerMask) { } 1.54.2
    uintptr_t get_MyFollowCamera = 0xA516E8; // public FollowCamera get_MyFollowCamera() 1.54.2
    uintptr_t IsSameTeam = 0x21E49E8; // protected override void OnUIInit() 1.54.2
    uintptr_t AttackableEntity_GetIsDead = 0x1D57DA4; // public bool get_IsDead() 1.54.2
    uintptr_t AttackableEntity_IsVisible = 0x1D57E9C; // public virtual bool IsVisible() 1.54.2
    uintptr_t Camera_WorldToScreenPoint =  0x2724AA0; // public Vector3 WorldToScreenPoint(Vector3 position)1.54.2
    uintptr_t Camera_main = 0x2725090; // public static Camera get_main 1.54.2
    uintptr_t telamento2 = 0x14BE898; // public int get_CurrentSpectatorCount 1.54.2
    uintptr_t telamentoforce = 0x2D1C0AC; // public uint[] get_spectators() 1.54.2
    uintptr_t noRecoil = 0xACBC84; // public float GetScatterRate 1.54.2
    uintptr_t GetHead = 0xA8D704; // 1.54.2  
    uintptr_t GetHipTF = 0xA8D830; // 1.54.2
    uintptr_t CurrentMatch = 0x1FBEDF8; // 1.54.2
    uintptr_t GetLocalPlayer2 = 0x15974D0; // 1.54.2
    uintptr_t getPlayerByIndex = 0x1597968; // 1.54.2
    uintptr_t get_CurHP = 0xA82994; // 1.54.2
    uintptr_t get_PlayerID = 0xA31FAC; // 1.54.2
    uintptr_t get_IsDieing = 0xA515F4; // 1.54.2
    uintptr_t get_IsSkyDiving = 0xA3D93C; // 1.54.2
    uintptr_t get_IsSkyDashing = 0xA52EE8; // 1.54.2
    uintptr_t get_IsParachuting = 0xA3D994; // 1.54.2
    uintptr_t SetAimRotation = 0xA51D64; // 1.54.2
    uintptr_t get_MaxHP = 0x23F3068; // 1.54
    uintptr_t il2cpp_string_new = 0x2E2CE0C; // 1.53.2  no DUMP
    uintptr_t String_Concat = 0x22741E0; // 1.54.2
    uintptr_t Screen_get_width = 0x2B8B3AC; // 1.54.2
    uintptr_t Screen_get_height = 0x2B8B43C; // 1.54.2
    uintptr_t get_IsCrouching = 0xA5B85C; // 1.54.2
    uintptr_t get_main = 0x2725090; // 1.54.2
    uintptr_t Component_get_transform = 0x2729DC4; // 1.54.2
    uintptr_t Transform_get_position = 0x2D3638C; // 1.54.2
    uintptr_t IsVisible = 0xA53758; // 1.54.2 
    uintptr_t IsLocalPlayer = 0xA54178; // 1.54.2
    uintptr_t Transform_get_forward = 0x2D36A70;  // 1.54.2
    uintptr_t IsLocalTeammate = 0xA59E10; // 1.54.2
    
} Global;

#endif
