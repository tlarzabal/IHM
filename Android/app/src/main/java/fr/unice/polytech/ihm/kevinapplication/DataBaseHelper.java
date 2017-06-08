package fr.unice.polytech.ihm.kevinapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.ihm.kevinapplication.model.bd.Camion;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Notification;
import fr.unice.polytech.ihm.kevinapplication.model.bd.TypeNotification;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Magasin;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Responsable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "database.sqlite";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void openDataBase() throws SQLException, IOException {
        //Open the database
        String myPath = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                // Copy the database in assets to the application database.
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database", e);
            }
        }
    }

    private boolean checkDataBase(){
        File databasePath = myContext.getDatabasePath(DB_NAME);
        return databasePath.exists();
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }





    public Responsable getResponsable(){
        Cursor cursor1= myDataBase.rawQuery("SELECT * FROM Responsable", null);
        cursor1.moveToFirst();
        Responsable responsable=new Responsable(
                cursor1.getString(0),
                cursor1.getString(1),
                cursor1.getString(2),
                cursor1.getInt(3));

        return responsable;
    }




    public ArrayList<Magasin> getAllMagasins(){
        ArrayList<Magasin> articles=new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM Magasin ", null);
        cursor.moveToFirst();
        Magasin art;

        while((art = getNextMagasin(cursor))!=null){
            articles.add(art);
        }

        cursor.close();
        return articles;
    }

    public Magasin getNextMagasin(Cursor cursor){
        if(!cursor.isAfterLast()) {
            Magasin magasin = new Magasin(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getDouble(4),
                    cursor.getDouble(5)

            );
            cursor.moveToNext();
            return magasin;
        }
        cursor.close();
        return null;
    }

    public List<TypeNotification> getTypeNotifications(){
        ArrayList<TypeNotification> notifications=new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM TypeNotification ", null);
        cursor.moveToFirst();
        TypeNotification not;
        while(!cursor.isAfterLast()){
            not = new TypeNotification(
                    cursor.getString(0),
                    cursor.getInt(1));
            notifications.add(not);
            cursor.moveToNext();
        }

        cursor.close();
        return notifications;
    }
    public void updateNotification(TypeNotification n){
        int i=0;
        if(n.isActif())
            i=1;
        myDataBase.execSQL("UPDATE TypeNotification SET actif = "+i+" WHERE nom ='"+n.getNom()+"'");
    }

    public ArrayList<Notification> getNotificationsActif(){
        ArrayList<Notification> notifications=new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT Notification.nom,Notification.date,Notification.id_magasin,Notification.descriptif,Magasin.image " +
                "FROM Notification JOIN TypeNotification ON TypeNotification.nom=Notification.nom JOIN Magasin ON Magasin.id=Notification.id_magasin " +
                "WHERE TypeNotification.actif=1 AND date>CURRENT_DATE ORDER BY Notification.date DESC", null);
        cursor.moveToFirst();
        Notification not;
        while(!cursor.isAfterLast()){
            not = new Notification(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3));
            notifications.add(not);
            cursor.moveToNext();
        }

        cursor.close();
        return notifications;
    }

    public ArrayList<Notification> getNotificationsPassif(){
        ArrayList<Notification> notifications=new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT Notification.nom,Notification.date,Notification.id_magasin,Notification.descriptif,magasin.image " +
                "FROM Notification JOIN TypeNotification ON TypeNotification.nom=Notification.nom JOIN Magasin ON Magasin.id=Notification.id_magasin " +
                "WHERE TypeNotification.actif=1 AND date<CURRENT_DATE ORDER BY Notification.date DESC", null);
        cursor.moveToFirst();
        Notification not;
        while(!cursor.isAfterLast()){
            not = new Notification(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3));
            notifications.add(not);
            cursor.moveToNext();
        }

        cursor.close();
        return notifications;
    }

    public ArrayList<Camion> getCamions(int i){
        ArrayList<Camion> camions=new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM Camion Where id_magasin=1 AND date>=CURRENT_DATE AND date<date('now','+"+i+" day') ORDER BY date ASC", null);
        cursor.moveToFirst();
        Camion camion;
        while(!cursor.isAfterLast()){
            camion = new Camion(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)
                    );
            camions.add(camion);
            cursor.moveToNext();
        }
        cursor.close();
        return camions;
    }


}


