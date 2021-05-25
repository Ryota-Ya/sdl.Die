package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Pencil implements Obj {

    private final static float[] VERTICES = {
            // bottom
            0.0f, -1.5f, 0.0f,
            0.5f, -1.5f, 0.0f,
            0.25f, -1.5f, -0.43f,
            -0.25f, -1.5f, -0.43f,
            -0.5f, -1.5f, 0.0f,
            -0.25f, -1.5f, 0.43f,
            0.25f, -1.5f, 0.43f,
            0.5f, -1.5f, 0.0f,

            // side1
            0.5f, -1.5f, 0.0f,
            0.25f, -1.5f, -0.43f,
            0.5f, 1.5f, 0.0f,
            0.25f, 1.5f, -0.43f,

            // side2
            0.25f, -1.5f, -0.43f,
            -0.25f, -1.5f, -0.43f,
            0.25f, 1.5f, -0.43f,
            -0.25f, 1.5f, -0.43f,

            // side3
            -0.25f, -1.5f, -0.43f,
            -0.5f, -1.5f, 0.0f,
            -0.25f, 1.5f, -0.43f,
            -0.5f, 1.5f, 0.0f,

            // side4
            -0.5f, -1.5f, 0.0f,
            -0.25f, -1.5f, 0.43f,
            -0.5f, 1.5f, 0.0f,
            -0.25f, 1.5f, 0.43f,

            // side5
            -0.25f, -1.5f, 0.43f,
            0.25f, -1.5f, 0.43f,
            -0.25f, 1.5f, 0.43f,
            0.25f, 1.5f, 0.43f,

            // side6
            0.25f, -1.5f, 0.43f,
            0.5f, -1.5f, 0.0f,
            0.25f, 1.5f, 0.43f,
            0.5f, 1.5f, 0.0f,

            // top1
            0.5f, 1.5f, 0.0f,
            0.25f, 1.5f, -0.43f,
            0.0f, 2.0f, 0.0f,

            // top2
            0.25f, 1.5f, -0.43f,
            -0.25f, 1.5f, -0.43f,
            0.0f, 2.0f, 0.0f,

            // top3
            -0.25f, 1.5f, -0.43f,
            -0.5f, 1.5f, 0.0f,
            0.0f, 2.0f, 0.0f,

            // top4
            -0.5f, 1.5f, 0.0f,
            -0.25f, 1.5f, 0.43f,
            0.0f, 2.0f, 0.0f,

            // top5
            -0.25f, 1.5f, 0.43f,
            0.25f, 1.5f, 0.43f,
            0.0f, 2.0f, 0.0f,

            // top6
            0.25f, 1.5f, 0.43f,
            0.5f, 1.5f, 0.0f,
            0.0f, 2.0f, 0.0f,

    };

    private final FloatBuffer vbuf;

    Pencil() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // bottom
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 8);


        // side1
        gl.glNormal3f(0.86f, 0.0f, -0.5f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);

        // side2
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);

        // side3
        gl.glNormal3f(-0.86f, 0.0f, -0.5f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);

        // side4
        gl.glNormal3f(-0.86f, 0.0f, 0.5f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);

        // side5
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 24, 4);

        // side6
        gl.glNormal3f(0.86f, 0.0f, 0.5f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 28, 4);


        // top1
        gl.glNormal3f(0.6f, 0.7f, -0.35f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 32, 3);

        // top2
        gl.glNormal3f(0.0f, 0.7f, -0.7f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 35, 3);

        // top3
        gl.glNormal3f(-0.6f, 0.7f, -0.35f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 38, 3);

        // top4
        gl.glNormal3f(-0.6f, 0.7f, 0.35f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 41, 3);

        // top5
        gl.glNormal3f(0.0f, 0.7f, 0.7f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 44, 3);

        // top6
        gl.glNormal3f(0.6f, 0.7f, 0.35f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 47, 3);
    }
}
