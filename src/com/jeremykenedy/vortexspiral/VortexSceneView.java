package com.jeremykenedy.vortexspiral;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.View;
import java.util.Random;

final class VortexSceneView extends View {
    private static final int[][] PALETTES = {
        {0xff40d8ff, 0xff3683ff, 0xffbd70ff},
        {0xffff4fc8, 0xff8e62ff, 0xff31c9ff},
        {0xff45ff94, 0xff00d5ac, 0xff86ffcf},
        {0xffffd16a, 0xffff806a, 0xffbd70ff, 0xff66dcff}
    };
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path path = new Path();
    private final VortexOptions options;
    private final float[] starX = new float[120];
    private final float[] starY = new float[120];
    private boolean running;
    private long startedAt;
    private float radius;
    private RadialGradient background;
    private final Runnable invalidator = new Runnable() {
        @Override public void run() { if (running) invalidate(); }
    };

    VortexSceneView(Context context) {
        super(context);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        options = VortexOptions.resolve(preferences.getString("density", "handful"),
                preferences.getString("motion", "normal"), preferences.getString("color", "cyan"),
                preferences.getString("brightness", "balanced"), preferences.getString("shape", "tight"),
                preferences.getBoolean("randomize_all", false), new Random());
        Random stars = new Random(8415);
        for (int i = 0; i < starX.length; i++) {
            starX[i] = stars.nextFloat();
            starY[i] = stars.nextFloat();
        }
    }

    void start() {
        if (running) return;
        startedAt = SystemClock.uptimeMillis();
        running = true;
        postInvalidateOnAnimation();
    }

    void stop() {
        running = false;
        removeCallbacks(invalidator);
    }

    @Override protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        radius = (float) Math.hypot(width, height) * 0.58f;
        background = new RadialGradient(width * 0.5f, height * 0.5f, radius,
                new int[] {0xff1b153e, 0xff080c21, 0xff02040c}, null, Shader.TileMode.CLAMP);
    }

    @Override protected void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) return;
        float time = (SystemClock.uptimeMillis() - startedAt) / 1000f * options.speed;
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(background);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setShader(null);
        for (int i = 0; i < starX.length; i++) {
            paint.setColor(0xffa2c6ec);
            paint.setAlpha((int) ((45 + 30 * Math.sin(time * 0.2f + i)) * options.brightness));
            canvas.drawCircle(starX[i] * getWidth(), starY[i] * getHeight(), 1 + i % 2, paint);
        }
        float centerX = getWidth() * (0.5f + 0.025f * (float) Math.sin(time * 0.04f));
        float centerY = getHeight() * (0.5f + 0.025f * (float) Math.cos(time * 0.05f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        int[] colors = PALETTES[options.palette];
        for (int arm = 0; arm < options.count; arm++) {
            for (int ribbon = 0; ribbon < 3; ribbon++) {
                path.reset();
                for (int point = 0; point <= 100; point++) {
                    float distance = point / 100f;
                    double angle = arm * Math.PI * 2 / options.count + time * 0.14f
                            - distance * (options.open ? 9.0 : 15.0) + ribbon * 0.035
                            + Math.sin(distance * 8 - time * 0.5f) * 0.06;
                    float r = 12 + radius * distance * distance;
                    float x = centerX + r * (float) Math.cos(angle);
                    float y = centerY + r * (float) Math.sin(angle) * 0.78f;
                    if (point == 0) path.moveTo(x, y); else path.lineTo(x, y);
                }
                paint.setColor(colors[arm % colors.length]);
                paint.setAlpha((int) ((ribbon == 1 ? 160 : 70) * options.brightness));
                paint.setStrokeWidth(ribbon == 1 ? 3f : 9f);
                canvas.drawPath(path, paint);
            }
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xff01020a);
        canvas.drawCircle(centerX, centerY, 13, paint);
        if (running) postDelayed(invalidator, 33L);
    }
}
