/*
 * Credit:
 *
 * Octowolve - Mod menu: https://github.com/z3r0Sec/Substrate-Template-With-Mod-Menu
 * And hooking: https://github.com/z3r0Sec/Substrate-Hooking-Example
 * VanHoevenTR A.K.A Nixi: https://github.com/LGLTeam/VanHoevenTR_Android_Mod_Menu
 * MrIkso - Mod menu: https://github.com/MrIkso/FloatingModMenu
 * Rprop - https://github.com/Rprop/And64InlineHook
 * MJx0 A.K.A Ruit - KittyMemory: https://github.com/MJx0/KittyMemory
 * */

package uk.lgl.modmenu;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;

import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static uk.lgl.modmenu.StaticActivity.cacheDir;
import android.net.ConnectivityManager;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URL;
import android.os.AsyncTask;
import android.annotation.SuppressLint;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.FileOutputStream;

public class FloatingModMenuService extends Service {
    private MediaPlayer FXPlayer;
    public View mFloatingView;
    private Button close;
    private Button kill;
    private LinearLayout mButtonPanel;
    public RelativeLayout mCollapsed;
    public LinearLayout mExpanded;
    private RelativeLayout mRootContainer;
    public WindowManager mWindowManager;
    public WindowManager.LayoutParams params;
    private LinearLayout patches;
    private FrameLayout rootFrame;
    private ImageView startimage;
    private LinearLayout view1;
    private LinearLayout view2;

    private AlertDialog alert;
    private EditText edittextvalue;

    private static final String TAG = "Mod Menu";

    //initialize methods from the native library
    public static native String Toast();

    private native String Icon();

    private native String Title();

    private native String Heading();

    private native boolean EnableSounds();

    private native int IconSize();

    public native void Changes(int feature, int value);

    private native String[] getFeatureListttttttttt();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Override our Start Command so the Service doesnt try to recreate itself when the App is closed
    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }

    //When this Class is called the code in this function will be executed
    @Override
    public void onCreate() {
        super.onCreate();
        //A little message for the user when he opens the app
        //Toast.makeText(this, Toast(), Toast.LENGTH_LONG).show();
        //Init Lib

        // When you change the lib name, change also on Android.mk file
        // Both must have same name
        System.loadLibrary("AnaGaby");


        initFloating();
        CreateMenuList();
        initAlertDiag();
        final Handler handler = new Handler();
        handler.post(new Runnable() {
				public void run() {
					handler.postDelayed(this, 1000);
				}
			});
    }



    //Here we write the code for our Menu

    private void initFloating() {
        rootFrame = new FrameLayout(getBaseContext()); // Global markup
        mRootContainer = new RelativeLayout(getBaseContext()); // Markup on which two markups of the icon and the menu itself will be placed
        mCollapsed = new RelativeLayout(getBaseContext()); // Markup of the icon (when the menu is minimized)
        mExpanded = new LinearLayout(getBaseContext()); // Menu markup (when the menu is expanded)
        view1 = new LinearLayout(getBaseContext());
        patches = new LinearLayout(getBaseContext());
        view2 = new LinearLayout(getBaseContext());
        mButtonPanel = new LinearLayout(getBaseContext()); // Layout of option buttons (when the menu is expanded)

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        relativeLayout.setPadding(3, 0, 3, 3);
        relativeLayout.setVerticalGravity(16);

        kill = new Button(this);
		kill.setBackgroundColor(Color.parseColor("#00000000"));
		kill.setText("[ ocultar ]");

		kill.setTextColor(Color.parseColor("WHITE"));
		android.graphics.drawable.GradientDrawable CCDIFDH = new android.graphics.drawable.GradientDrawable();
		int CCDIFDHADD[] = new int[]{ Color.argb(255,155,15,15), Color.argb(255,0,15,255) };
		CCDIFDH.setColors(CCDIFDHADD);
		CCDIFDH.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
		CCDIFDH.setCornerRadius(5);
		CCDIFDH.setStroke(5, Color.argb(255,15,15,15));
		kill.setBackground(CCDIFDH);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
		layoutParams.addRule(11);

		this.close = new Button(this);
		this.close.setBackgroundColor(Color.parseColor("#00000000"));
		this.close.setText("[ close ]");

		this.close.setTextColor(Color.WHITE);
		close.getBackground().setAlpha(250);
		this.close.setLayoutParams(layoutParams);
		android.graphics.drawable.GradientDrawable BDFEHGB = new android.graphics.drawable.GradientDrawable();
		int BDFEHGBADD[] = new int[]{ Color.argb(255,155,15,15), Color.argb(255,0,15,255) };
		BDFEHGB.setColors(BDFEHGBADD);
		BDFEHGB.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
		BDFEHGB.setCornerRadius(5);
		BDFEHGB.setStroke(5, Color.argb(255,15,15,15));
		close.setBackground(BDFEHGB);
		relativeLayout.addView(kill);
		relativeLayout.addView(close);

        rootFrame.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        mRootContainer.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        mCollapsed.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        mCollapsed.setVisibility(View.VISIBLE);
        startimage = new ImageView(getBaseContext());
        startimage.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        int applyDimension = (int) TypedValue.applyDimension(1, (float) IconSize(), getResources().getDisplayMetrics());
        startimage.getLayoutParams().height = applyDimension;
        startimage.getLayoutParams().width = applyDimension;
        startimage.requestLayout();
        startimage.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode = Base64.decode(Icon(), 0);
        startimage.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        ((ViewGroup.MarginLayoutParams) startimage.getLayoutParams()).topMargin = convertDipToPixels(10);

        mExpanded.setVisibility(View.GONE);
        mExpanded.setBackgroundColor(Color.parseColor("BLACK"));
        mExpanded.setAlpha(0.95f);
        mExpanded.setGravity(17);
        mExpanded.setOrientation(LinearLayout.VERTICAL);
        mExpanded.setPadding(0, 0, 0, 0);
		android.graphics.drawable.GradientDrawable JCFADDB = new android.graphics.drawable.GradientDrawable();
		int JCFADDBADD[] = new int[]{ Color.argb(255,230,15,0), Color.argb(255,0,0,140) };
		JCFADDB.setColors(JCFADDBADD);
		
		JCFADDB.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
		JCFADDB.setCornerRadius(26);
		mExpanded.setBackground(JCFADDB);
		if(Build.VERSION.SDK_INT >= 21) { mExpanded.setElevation(100f); }
	
        //Auto size. To set size manually, change the width and height example 500, 500
        mExpanded.setLayoutParams(new LinearLayout.LayoutParams(dp(230), dp(330)));

        ScrollView scrollView = new ScrollView(getBaseContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(205)));

        view1.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
        view1.setBackgroundColor(Color.parseColor("#000000"));
        patches.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        patches.setOrientation(LinearLayout.VERTICAL);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
        view2.setBackgroundColor(Color.parseColor("#000000"));
        view2.setPadding(0, 0, 0, 10);
        mButtonPanel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));

        //Title text
        TextView textView = new TextView(getBaseContext());
        textView.setText(Title());
        textView.setTextColor(Color.parseColor("#ff00ddff"));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(20.0f);
        textView.setPadding(0, 10, 0, 5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        //textView.setLayoutParams(layoutParams2);

        //Heading text
        TextView textView2 = new TextView(getBaseContext());
        textView2.setText(Html.fromHtml(Heading()));
        textView2.setTextColor(Color.parseColor("#ff00ddff"));
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextSize(14.0f);
        textView2.setPadding(10, 5, 10, 10);

        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView2.setLayoutParams(layoutParams3);
        new LinearLayout.LayoutParams(-1, dp(25)).topMargin = dp(2);
        rootFrame.addView(mRootContainer);
        mRootContainer.addView(mCollapsed);
        mRootContainer.addView(mExpanded);

        mCollapsed.addView(startimage);

        mExpanded.addView(textView);
        mExpanded.addView(textView2);
        mExpanded.addView(view1);
        mExpanded.addView(scrollView);
        scrollView.addView(patches);
        mExpanded.addView(view2);
        mExpanded.addView(relativeLayout);
        mFloatingView = rootFrame;
        if (Build.VERSION.SDK_INT >= 26) {
            params = new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        } else {
            params = new WindowManager.LayoutParams(-2, -2, 2002, 8, -3);
        }
        WindowManager.LayoutParams layoutParams4 = params;
        layoutParams4.gravity = 51;
        layoutParams4.x = 0;
        layoutParams4.y = 100;
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);

        RelativeLayout relativeLayout2 = mCollapsed;
        LinearLayout linearLayout = mExpanded;
        mFloatingView.setOnTouchListener(onTouchListener());
        startimage.setOnTouchListener(onTouchListener());
        initMenuButton(relativeLayout2, linearLayout);

    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = mCollapsed;
            final View expandedView = mExpanded;
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);

                        //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                        //So that is click event.
                        if (rawX < 10 && rawY < 10 && isViewCollapsed()) {
                            //When user clicks on the image view of the collapsed layout,
                            //visibility of the collapsed layout will be changed to "View.GONE"
                            //and expanded view will become visible.
                            collapsedView.setVisibility(View.GONE);
                            expandedView.setVisibility(View.VISIBLE);
                            playSound(Uri.fromFile(new File(cacheDir + "OpenMenu.ogg")));
							Toast.makeText(FloatingModMenuService.this, Html.fromHtml(Toast()), Toast.LENGTH_SHORT).show();
							
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //Calculate the X and Y coordinates of the view.
                        params.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        params.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));

                        //Update the layout with new X & Y coordinate
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    //Initialize event handlers for buttons, etc.
    private void initMenuButton(final View view2, final View view3) {
        startimage.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					view2.setVisibility(View.GONE);
					view3.setVisibility(View.VISIBLE);
				}
			});
        kill.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					//FloatingModMenuService.stopSelf();
					// view2.setVisibility(View.VISIBLE)
					view2.setVisibility(View.VISIBLE);
					view2.setAlpha(0);
					view3.setVisibility(View.GONE);
				}
			});
        close.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					view2.setVisibility(View.VISIBLE);
					view2.setAlpha(0.95f);
					view3.setVisibility(View.GONE);
					//Log.i("LGL", "Close");
				}
			});
    }

    private void CreateMenuList() {
        String[] listFT = getFeatureListttttttttt();
        for (int i = 0; i < listFT.length; i++) {
            final int feature = i;
            String str = listFT[i];
            if (str.contains("Toggle_")) {

                addSwitch(str.replace("Toggle_", ""), new InterfaceBool() {
						public void OnWrite(boolean z) {
							Changes(feature, 0);
						}
					});
            } else if (str.contains("SeekBar_")) {
                String[] split = str.split("_");
                addSeekBar(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
						public void OnWrite(int i) {
							Changes(feature, i);
						}
					});
            } else if (str.contains("SeekBarSpot_")) {
                String[] split = str.split("_");
                addSeekBarSpot(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
						public void OnWrite(int i) {
							Changes(feature, i);
						}
					});
            } else if (str.contains("Category_")) {
                addCategory(str.replace("Category_", ""));
            } else if (str.contains("Button_")) {
                addButton(str.replace("Button_", ""), new InterfaceBtn() {
						public void OnWrite() {
							Changes(feature, 0);
						}
					});
            } else if (str.contains("Spinner_")) {
                addSpinner(str.replace("Spinner_", ""), new InterfaceInt() {
						@Override
						public void OnWrite(int i) {
							Changes(feature, i);
						}
					});
            } else if (str.contains("InputValue_")) {
                addTextField(str.replace("InputValue_", ""), feature, new InterfaceInt() {
						@Override
						public void OnWrite(int i) {
							Changes(feature, 0);
						}
					});
            }
        }
    }

    private TextView textView2;
    private String featureNameExt;
    private int featureNum;
    private EditTextValue txtValue;

    public class EditTextValue {
        private int val;

        public void setValue(int i) {
            val = i;
        }

        public int getValue() {
            return val;
        }
    }

    private void addTextField(final String featureName, final int feature, final InterfaceInt interInt) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        relativeLayout2.setPadding(10, 5, 10, 5);
        relativeLayout2.setVerticalGravity(16);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 10;

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + featureName + ": <font color='#fdd835'>Not set</font></font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setLayoutParams(layoutParams);

        final TextView textViewRem = new TextView(this);
        textViewRem.setText("");

        final EditTextValue edittextval = new EditTextValue();

        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        Button button2 = new Button(this);
        button2.setLayoutParams(layoutParams2);
        button2.setBackgroundColor(Color.parseColor("#1C262D"));
        button2.setText("SET");
        button2.setTextColor(Color.parseColor("#D5E3EB"));
        button2.setGravity(17);
        button2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					alert.show();
					textView2 = textView;
					featureNum = feature;
					featureNameExt = featureName;
					txtValue = edittextval;

					edittextvalue.setText(String.valueOf(edittextval.getValue()));
				}
			});

        relativeLayout2.addView(textView);
        relativeLayout2.addView(button2);
        patches.addView(relativeLayout2);
    }

    private void initAlertDiag() {
        LinearLayout linearLayout1 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout1.setPadding(10, 5, 0, 5);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setGravity(17);
        linearLayout1.setLayoutParams(layoutParams);
        linearLayout1.setBackgroundColor(Color.parseColor("#FF0000"));

        int i = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#14171f"));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>Tap OK to apply changes. Tap outside to cancel</font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setLayoutParams(layoutParams);

        edittextvalue = new EditText(this);
        edittextvalue.setLayoutParams(layoutParams);
        edittextvalue.setMaxLines(1);
        edittextvalue.setWidth(convertDipToPixels(300));
        edittextvalue.setTextColor(Color.parseColor("#93a6ae"));
        edittextvalue.setTextSize(13.0f);
        edittextvalue.setHintTextColor(Color.parseColor("#434d52"));
        edittextvalue.setInputType(InputType.TYPE_CLASS_NUMBER);
        edittextvalue.setKeyListener(DigitsKeyListener.getInstance("0123456789-"));

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(10);
        edittextvalue.setFilters(FilterArray);

        Button button = new Button(this);
        button.setBackgroundColor(Color.parseColor("#1C262D"));
        button.setTextColor(Color.parseColor("#D5E3EB"));
        button.setText("OK");
        button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Changes(featureNum, Integer.parseInt(edittextvalue.getText().toString()));
					txtValue.setValue(Integer.parseInt(edittextvalue.getText().toString()));
					textView2.setText(Html.fromHtml("<font face='roboto'>" + featureNameExt + ": <font color='#41c300'>" + edittextvalue.getText().toString() + "</font></font>"));
					alert.dismiss();
					playSound(Uri.fromFile(new File(cacheDir + "Select.ogg")));
					//interStr.OnWrite(editText.getText().toString());
				}
			});

        alert = new AlertDialog.Builder(this, 2).create();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(alert.getWindow()).setType(i);
        }
        linearLayout1.addView(textView);
        linearLayout1.addView(edittextvalue);
        linearLayout1.addView(button);
        alert.setView(linearLayout1);
    }

    private void addSpinner(String feature, final InterfaceInt interInt) {
        List<String> list = new LinkedList<>(Arrays.asList(feature.split("_")));

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 10, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#00000000"));
		
		
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + list.get(0) + ": <font color='#41c300'></font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));

        // Create another LinearLayout as a workaround to use it as a background
        // and to keep the 'down' arrow symbol
        // If spinner had the setBackgroundColor set, there would be no arrow symbol
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(10, 2, 10, 5);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundColor(Color.parseColor("#00000000"));
        linearLayout2.setLayoutParams(layoutParams2);

        Spinner spinner = new Spinner(this);
        spinner.setPadding(5, 10, 5, 8);
        spinner.setLayoutParams(layoutParams2);
        spinner.getBackground().setColorFilter(1, PorterDuff.Mode.SRC_ATOP); //trick to show white down arrow color
        //Creating the ArrayAdapter instance having the list
        list.remove(0);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
					((TextView) parentView.getChildAt(0)).setTextColor(Color.parseColor("#f5f5f5"));
					interInt.OnWrite(position);
					playSound(Uri.fromFile(new File(cacheDir + "Select.ogg")));
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					playSound(Uri.fromFile(new File(cacheDir + "Select.ogg")));
				}
			});
        linearLayout.addView(textView);
        linearLayout2.addView(spinner);
        patches.addView(linearLayout);
        patches.addView(linearLayout2);
    }

    private void addCategory(String text) {
        TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.parseColor("#2F3D4C"));
        textView.setText(text);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setTypeface(null, Typeface.BOLD);
        textView.setPadding(10, 5, 0, 5);
        patches.addView(textView);
    }

    public void addButton(String feature, final InterfaceBtn interfaceBtn) {
        final Button button = new Button(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(7, 5, 7, 5);
        button.setLayoutParams(layoutParams);
        button.setPadding(10, 5, 10, 5);
        button.setTextSize(13.0f);
        button.setTextColor(Color.parseColor("#FF0000"));
        button.setGravity(17);

		if (feature.contains("OnOff_")) {
            feature = feature.replace("OnOff_", "");
            button.setText(feature + " OFF");
            button.setBackgroundColor(Color.parseColor("#FF0000"));
            GradientDrawable px = new GradientDrawable();
            px.setShape(GradientDrawable.RECTANGLE);
            px.setCornerRadius(8);
            px.setGradientType(GradientDrawable.LINEAR_GRADIENT);
            px.setStroke(2, (Color.parseColor("#FF0000")));
            px.setColor(Color.parseColor("#FF0000"));
			button.setBackground(px);
            final String feature2 = feature;
            button.setOnClickListener(new View.OnClickListener() {
					private boolean isActive = true;

					public void onClick(View v) {
						interfaceBtn.OnWrite();
						if (isActive) {
							button.setText(feature2 + " ON");
							button.setBackgroundColor(Color.parseColor("#00BFFF"));
							GradientDrawable bt = new GradientDrawable();
							bt.setShape(GradientDrawable.RECTANGLE);
							bt.setCornerRadius(8);  
							bt.setGradientType(GradientDrawable.LINEAR_GRADIENT);
							bt.setStroke(2, (Color.parseColor("#00BFFF")));
							bt.setColor(Color.parseColor("#00BFFF"));
							button.setBackground(bt);
							isActive = false;
							return;
						}
						button.setText(feature2 + " OFF");
						button.setBackgroundColor(Color.parseColor("#FF0000"));
						GradientDrawable px = new GradientDrawable();
						px.setShape(GradientDrawable.RECTANGLE);
						px.setCornerRadius(8);
						px.setGradientType(GradientDrawable.LINEAR_GRADIENT);
						px.setStroke(2, (Color.parseColor("#00BFFF")));
						px.setColor(Color.parseColor("#FF0000"));
						button.setBackground(px);
						isActive = true;
					}
				});
        } else {
            button.setText(feature);
            button.setBackgroundColor(Color.parseColor("#000000"));
            final String feature2 = feature;
            button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						interfaceBtn.OnWrite();
					}
				});
        }
        patches.addView(button);
    }

    private void addSwitch(String str, final InterfaceBool sw) {
        final Switch switchR = new Switch(this);
        switchR.setBackgroundColor(Color.parseColor("#00000000"));
        switchR.setText(Html.fromHtml("<font face='monospace'><b>" + str + "</b></font>"));
        switchR.setTextColor(Color.parseColor("#ff00ddff"));
        switchR.setPadding(10, 5, 0, 5);
        switchR.getTrackDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
        switchR.getThumbDrawable().setColorFilter(Color.parseColor("RED"), PorterDuff.Mode.SRC_IN);
        


        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        switchR.setBackgroundColor(Color.parseColor("#00000000"));
                        switchR.getTrackDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
                        switchR.getThumbDrawable().setColorFilter(Color.parseColor("GREEN"), PorterDuff.Mode.SRC_IN);
						
                    } else {
                        switchR.setBackgroundColor(Color.parseColor("#00000000"));
                        switchR.getTrackDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
                        switchR.getThumbDrawable().setColorFilter(Color.parseColor("RED"), PorterDuff.Mode.SRC_IN);
					
                    }
                    if (z) {

					} else {

					}
					sw.OnWrite(z);
				}
			});
        patches.addView(switchR);
    }
	

    private void addSeekBar(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#00000000"));
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + feature + ": <font color='#FF0000'>" + prog + "</font>"));
        textView.setTextColor(Color.parseColor("#ff00ddff"));
		textView.setTypeface((Typeface) null, 1);
		
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25,10,35,10);
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("#00FF00"), PorterDuff.Mode.SRC_IN);
		seekBar.getThumb().setColorFilter(Color.parseColor("#00FFFF"), PorterDuff.Mode.SRC_IN);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        seekBar.setMax(max);
        
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar) {
				}

				public void onStopTrackingTouch(SeekBar seekBar) {
				}

				int l;

				public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
					if (l < i) {

					} else {

					}
					l = i;

					if (i < prog) {
						seekBar.setProgress(prog);
						interInt.OnWrite(prog);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='roboto'>" + feature + ": <font color='#FF0000'>" + prog + "</font>"));
						return;
					}
					interInt.OnWrite(i);
					textView.setText(Html.fromHtml("<font face='roboto'>" + feature + ": <font color='#FF0000'>" + i + "</font>"));
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }

    private void addSeekBarSpot(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + feature + ": <font color='#ff00ddff'>" + "Desativado" + "</font>"));
        textView.setTextColor(Color.parseColor("#ff00ddff"));
		textView.setTypeface((Typeface) null, 1);
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25,10,35,10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("#00FF00"), PorterDuff.Mode.SRC_IN);
		seekBar.getThumb().setColorFilter(Color.parseColor("#00FFFF"), PorterDuff.Mode.SRC_IN);
        seekBar.setMax(max);
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
        final SeekBar seekBar2 = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int l;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='roboto'><b>" + feature + ": <font color='#ff00ddff'>" + "Desativado" + "</b></font>"));
					} else if (i == 1) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='roboto'><b>" + feature + ": <font color='#ff00ddff'>" + "Cabeça" + "</b></font>"));
					} else if (i == 2) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='roboto'><b>" + feature + ": <font color='#ff00ddff'>" + "Corpo" + "</b></font>"));
					} else if (i == 3) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='roboto'><b>" + feature + ": <font color='#ff00ddff'>" + "Pé" + "</b></font>"));
					}
					interInt.OnWrite(i);
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }

    boolean delayed;

    public void playSound(Uri uri) {
        if (EnableSounds()) {
            if (!delayed) {
                delayed = true;
                if (FXPlayer != null) {
                    FXPlayer.stop();
                    FXPlayer.release();
                }
                FXPlayer = MediaPlayer.create(this, uri);
                if (FXPlayer != null)
				//Volume reduced so sounds are not too loud
                    FXPlayer.setVolume(0.5f, 0.5f);
                FXPlayer.start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							delayed = false;
						}
					}, 100);
            }
        }
    }

    public boolean isViewCollapsed() {
        return mFloatingView == null || mCollapsed.getVisibility() == View.VISIBLE;
    }

    //For our image a little converter
    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    //Destroy our View
    public void onDestroy() {
        super.onDestroy();

        if (view2 != null) {
            this.mWindowManager.removeView(view2);
        }
        View view = mFloatingView;
        if (view != null) {
            mWindowManager.removeView(view);
        }
    }

    // checking if any network connection / internet available

    // calling our AsyncTask Function that will do thee thing on fetching data from out host file

    // this is the checking one, this will draw our menu if it's license still valid or active

    //Check if we are still in the game. If now our Menu and Menu button will dissapear
    private boolean isNotInGame() {
        RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance != 100;
    }

    //Same as above so it wont crash in the background and therefore use alot of Battery life


    private interface InterfaceBtn {
        void OnWrite();
    }

    private interface InterfaceInt {
        void OnWrite(int i);
    }

    private interface InterfaceBool {
        void OnWrite(boolean z);
    }

    private interface InterfaceStr {
        void OnWrite(String s);
    }
}
