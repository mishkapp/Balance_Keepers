package blackgnomestudio.balancekeepers.renderers;

import org.lwjgl.util.glu.GLU;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 06.09.13
 * Time: 1:37
 * To change this template use File | Settings | File Templates.
 */
public class Camera {

    //TODO: Причесать

    private Vector3D position = new Vector3D();
    private Vector3D view = new Vector3D();
    private Vector3D up = new Vector3D();
    private Vector3D strafe = new Vector3D();

    private Vector3D cross(Vector3D v1, Vector3D v2, Vector3D vector2){
        Vector3D normalVector = new Vector3D();
        Vector3D vector1 = new Vector3D();
        vector1.x = v1.x - v2.x;
        vector1.y = v1.y - v2.y;
        vector1.z = v1.z - v2.z;

        normalVector.x = ((vector1.y * vector2.z) - (vector1.z * vector2.y));

        normalVector.y = ((vector1.z * vector2.x) - (vector1.x * vector2.z));

        normalVector.z = ((vector1.x * vector2.y) - (vector1.y * vector2.x));

        return normalVector;
    }

    private float magnitude(Vector3D normalVector)
    {
        return (float)Math.sqrt((normalVector.x * normalVector.x) +
                (normalVector.y * normalVector.y) +
                (normalVector.z * normalVector.z));
    }

    private Vector3D normalize(Vector3D vector)
    {
        float magnitude = magnitude(vector);

        vector.x = vector.x / magnitude;
        vector.y = vector.y / magnitude;
        vector.z = vector.z / magnitude;

        return vector;
    }

    public void setPosition(float posX, float posY, float posZ,
                                float viewX, float viewY, float viewZ,
                                float upX, float upY, float upZ)
    {
        position.x = posX;
        position.y = posY;
        position.z = posZ;
        view.x = viewX;
        view.y = viewY;
        view.z = viewZ;
        up.x = upX;
        up.y = upY;
        up.z = upZ;
    }

    public void rotate(float speed)
    {
        Vector3D vector = new Vector3D();// Полчим вектор взгляда
        vector.x = view.x - position.x;
        vector.y = view.y - position.y;
        vector.z = view.z - position.z;



        view.z = (float)(position.z + Math.sin(speed) * vector.x + Math.cos(speed) * vector.z);
        view.x = (float)(position.x + Math.cos(speed) * vector.x - Math.sin(speed) * vector.z);
    }

    public void rotate(float angle, float x, float y, float z)
    {
        position.x = position.x - view.x;
        position.y = position.y - view.y;
        position.z = position.z - view.z;

        Vector3D vector = position;
        Vector3D tempVector = new Vector3D();

        float SinA = (float)Math.sin(Math.PI * angle / 180.0);
        float CosA = (float)Math.cos(Math.PI * angle / 180.0);

        tempVector.x = (CosA + (1 - CosA) * x * x) * vector.x;
        tempVector.x += ((1 - CosA) * x * y - z * SinA) * vector.y;
        tempVector.x += ((1 - CosA) * x * z + y * SinA) * vector.z;

        tempVector.y = ((1 - CosA) * x * y + z * SinA) * vector.x;
        tempVector.y += (CosA + (1 - CosA) * y * y) * vector.y;
        tempVector.y += ((1 - CosA) * y * z - x * SinA) * vector.z;

        tempVector.z = ((1 - CosA) * x * z - y * SinA) * vector.x;
        tempVector.z += ((1 - CosA) * y * z + x * SinA) * vector.y;
        tempVector.z += (CosA + (1 - CosA) * z * z) * vector.z;

        position.x = view.x + tempVector.x;
        position.y = view.y + tempVector.y;
        position.z = view.z + tempVector.z;
    }

    public void move(float speed)
    {
        Vector3D vector = new Vector3D();
        vector.x = view.x - position.x;
        vector.y = view.y - position.y;
        vector.z = view.z - position.z;

        vector.y = 0.0f;
        vector = normalize(vector);

        position.x += vector.x * speed;
        position.z += vector.z * speed;
        view.x += vector.x * speed;
        view.z += vector.z * speed;
    }

    public void strafe(float speed)
    {
        position.x += strafe.x * speed;
        position.z += strafe.z * speed;

        view.x += strafe.x * speed;
        view.z += strafe.z * speed;
    }

    public void update()
    {
        Vector3D cross = cross(view, position, up);

        //Нормализуем вектор стрейфа
        strafe = normalize(cross);
    }

    public void upDown(float speed)
    {
        position.y += speed;
    }

    public void render()
    {
//        System.out.println(position.x+":"+position.y+":"+position.z);
//        System.out.println(view.x+":"+view.y+":"+view.z);
//        System.out.println(up.x+":"+up.y+":"+up.z);
        GLU.gluLookAt(position.x, position.y, position.z,
                view.x, view.y, view.z,
                up.x, up.y, up.z);
    }

    public double getPosX()
    {
        return position.x;
    }

    public double getPosY()
    {
        return position.y;
    }

    public double getPosZ()
    {
        return position.z;
    }

    public double getViewX()
    {
        return view.x;
    }

    public double getViewY()
    {
        return view.y;
    }

    public double getViewZ()
    {
        return view.z;
    }



}
