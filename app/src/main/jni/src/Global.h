#ifndef ANDROID_MOD_MENU_GLOBAL_H
#define ANDROID_MOD_MENU_GLOBAL_H

struct {
//y Means its Updated to 1.62.2
    uintptr_t MainCameraTransform = 0x5C;//y  // public Transform MainCameraTransform;
	uintptr_t Dictionary = 0x44; //y // protected Dictionary<byte, Player> NgEZJDq 
	uintptr_t HeadTF = 0x1C8;//y // protected Transform JoqBDUR;
	uintptr_t HipTF = 0x1CC;//y // protected Transform gBb{jci;
	uintptr_t HandTF = 0x1C4;//y // protected Transform yFayxSS;
	uintptr_t EyeTF = 0x1D0;//y // protected Transform S~D]ly;
	uintptr_t ToeTF = 0x1D8;//y // protected Transform |[tt{c;
	uintptr_t RightShoulder = 0x1FC; //y // protected Transform IcoOWF;
	uintptr_t LeftShoulder = 0x1F8;//y // protected Transform iuhFwSC;
    uintptr_t IsClientBot = 0xDC;//y // public bool IsClientBot;
	uintptr_t U3DStr = 0x27A4238;//y //private string CreateString(sbyte* value) { }
    uintptr_t U3DStrConcat = 0x27A2B60;//y //public static string Concat(string str0, string str1, string str2, string str3) { }
    uintptr_t Component_GetTransform = 0x27FA17C;//y // public Transform get_transform()
    uintptr_t GetCameraTrackableEntityTransfrom = 0x86069C;//y // public Transform GetCameraTrackableEntityTransfrom 
    uintptr_t Transform_INTERNAL_GetPosition = 0x29F21F4;//YY // private void INTERNAL_get_position 
    uintptr_t Transform_INTERNAL_SetPosition = 0x29F22BC;//yy // private void INTERNAL_set_position 
    uintptr_t GetForward = 0x29F2C34;//y // public Vector3 get_forward 
    uintptr_t get_isAlive = 0x8606A4;//y // public bool IsCameraTrackableEntityAlive 
    uintptr_t GetPhysXPose = 0x7F8D0C;//y // public xl^LGZc GetPhysXPose
    uintptr_t IsFiring = 0x7F8CC0;//y // public bool IsFiring 
    uintptr_t IsCrouching = 0x81B374;//y // public bool IsCrouching 
    uintptr_t get_IsSighting = 0x871B30;//y // public bool get_IsSighting 
    uintptr_t get_IsReallyDead = 0x811368;//y // public bool get_IsReallyDead 
    uintptr_t get_isLocalPlayer = 0x7F9B00;//y // public bool IsLocalPlayer 
    uintptr_t get_isLocalTeam = 0x819958;//y // public virtual bool IsLocalTeammate 
    uintptr_t get_isVisible = 0x812BFC;//y // public override bool IsVisible 
    uintptr_t set_aim = 0x810F18;//y // public void SetAimRotation 
    uintptr_t Camera_main_fov = 0x27F6584;//y // public float get_fieldOfView 
    uintptr_t get_imo = 0x815E30;//y // public FPnavhE GetActiveWeapon
    uintptr_t set_esp = 0x15FB224; //y	private void PTSvvtp() { } 
    uintptr_t GetAttackableCenterWS = 0x80FB18;//y // public override Vector3 GetAttackableCenterWS 
    uintptr_t GetCharacterControllerTopPosition = 0x855254;//y // public virtual Vector3 GetCharacterControllerTopPosition
    uintptr_t get_NickName = 0x810084;//y // public string get_NickName
    uintptr_t WorldToScreenPoint = 0x27F7F90;//y // public Vector3 WorldToScreenPoint
    uintptr_t get_height = 0x29E6810;//y // public static int get_height
    uintptr_t get_width = 0x29E678C;//y // public static int get_width 
    uintptr_t get_deltaTime = 0x29F0FD0;//y // public static float get_fixedDeltaTime
    uintptr_t CurrentUIScene = 0x11B46DC;//y // public static UICOWBaseScene CurrentUIScene
    uintptr_t Curent_Match = 0x11CCBB0;//y // public static Th|G[l[ CurrentMatch
    uintptr_t Current_Local_Player = 0x11CCED4;//y // public static Player CurrentLocalPlayer
    uintptr_t GetLocalPlayerOrObServer = 0x11CE59C;//y // public static Player GetLocalPlayerOrObServer
    uintptr_t CurrentLocalSpectator = 0x11CD44C;//y // public static olfyRLw CurrentLocalSpectator()
    uintptr_t Player_Index = 0x9EAA7C; // public Player elpb[T(byte Ox|uy|) { } 
    uintptr_t AddTeammateHud = 0x93A984;//y //	public void ShowAssistantText(string playerName, string line) { }
    uintptr_t spof_uid = 0x80FF64;//y // protected void kjkIWoo(ulong aKRQdu) { }
    uintptr_t spof_nick = 0x81008C;//y // protected void rhTOWJa(string aKRQdu) { }
    uintptr_t ShowDynamicPopupMessage = 0x923BC8;//y // public void ShowDynamicPopupMessage(string message, float duration = 5) { }
    uintptr_t ShowPopupMessage = 0x923D08;//y //	public void ShowPopupMessage(string message, float duration = 2) { } 
    uintptr_t GetLocalPlayer = 0x1341F24;//y // private static Player GetLocalPlayer() { }
    uintptr_t GetCharacterHeight = 0x823DEC;//y // public float GetCharacterHeight()
    uintptr_t set_height = 0x35E7160;//y // public void set_height(float value) { }
    uintptr_t get_CharacterController = 0x80CAA4;//y // public CharacterController get_CharacterController()
    uintptr_t IsUserControlChanged = 0x81B218;//y // public bool IsUserControlChanged()
    uintptr_t set_invitee_nickname = 0x35F0AA4;//y // public void set_invitee_nickname(string value) { } 
    uintptr_t Raycast = 0x35E89E0;//y // public static bool Raycast(Vector3 origin, Vector3 direction, float maxDistance, int layerMask) { }
    uintptr_t get_MyFollowCamera = 0x81099C;//y // public FollowCamera get_MyFollowCamera() 
    uintptr_t IsSameTeam = 0xDDABD0;//y // protected override void OnUIInit() 
    uintptr_t AttackableEntity_GetIsDead = 0xFD7E8C;//y // public bool get_IsDead() 
    uintptr_t AttackableEntity_IsVisible = 0xFE164C;//y // public virtual bool IsVisible() 
    uintptr_t Camera_WorldToScreenPoint =  0x27F7F90;//y // public Vector3 WorldToScreenPoint(Vector3 position)
    uintptr_t Camera_main = 0x27F8680;//y // public static Camera get_main 
    uintptr_t telamento2 = 0x1E26730;//y // public int get_CurrentSpectatorCount
    uintptr_t telamentoforce = 0x1F45FA0;//y // public uint[] get_spectators() 
    uintptr_t noRecoil = 0xC2F17C;//y // public float GetScatterRate
    uintptr_t GetHead = 0x854F1C;//y //public virtual Transform GetHeadTF() { } 
    uintptr_t GetHipTF = 0x855018;//y //public virtual Transform GetHipTF() { }
    uintptr_t CurrentMatch = 0x11CCBB0; //public static  CurrentMatch() { }
    uintptr_t GetLocalPlayer2 = 0x15974D0;
    uintptr_t getPlayerByIndex = 0x1597968; 
    uintptr_t get_CurHP = 0x847738;//y //public int get_CurHP() { }
    uintptr_t get_PlayerID = 0x80E288;//y //public {QAb~u get_PlayerID() { }
    uintptr_t get_IsDieing = 0x7FFAE8;//y //public bool get_IsDieing() { }
    uintptr_t get_IsSkyDiving = 0x7F8A1C;//y //public bool get_IsSkyDiving() { } 
    uintptr_t get_IsSkyDashing = 0x812474;//y //public bool get_IsSkyDashing() { }
    uintptr_t get_IsParachuting = 0x7F89E0;//y //public bool get_IsParachuting() { }
    uintptr_t SetAimRotation = 0x810F18;//y //public void SetAimRotation(Quaternion laYChSW) { }
    uintptr_t get_MaxHP = 0x23F3068; // 1.54
    uintptr_t il2cpp_string_new = 0x2E2CE0C; // 1.53.2  no DUMP
    uintptr_t String_Concat = 0x2795C5C;//y //public static string Concat(string str0, string str1) { }
    uintptr_t Screen_get_width = 0x29E678C;//y //public static int get_width() { }
    uintptr_t Screen_get_height = 0x29E6810;//y //public static int get_height() { }
    uintptr_t get_IsCrouching = 0x81B374;//y //public bool IsCrouching() { }
    uintptr_t get_main = 0x27F8680;//y //public static Camera get_main() { }
    uintptr_t Component_get_transform = 0x27FA17C;//y //public Transform get_transform() { }
    uintptr_t Transform_get_position = 0x29F21F4;//y //public Vector3 get_localPosition() { }
    uintptr_t IsVisible = 0x812BFC;//y //public override bool IsVisible() { }
    uintptr_t IsLocalPlayer = 0x7F9B00;//y //public bool IsLocalPlayer() { }
    uintptr_t Transform_get_forward = 0x29F2C34;//y  //public Vector3 get_forward() { }
    uintptr_t IsLocalTeammate = 0x819958;//y //public virtual bool IsLocalTeammate() { }
    
} Global;

#endif
