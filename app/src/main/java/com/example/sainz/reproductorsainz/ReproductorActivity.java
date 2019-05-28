package com.example.sainz.reproductorsainz;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.R.*;

//import java.util.ArrayList;

//import static com.example.sainz.reproductorsainz.R.raw2;

public class ReproductorActivity extends AppCompatActivity {
    //ArrayList<MediaPlayer> listaMusica= new ArrayList<MediaPlayer>();
    MediaPlayer vectorMusica[]=new MediaPlayer[5];
    String vectorNombre[]=new String[5];
    int posicion = 0;
    ImageView imagen;
    String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        final Button btnPlay = (Button) findViewById(R.id.btnPlay);
        //ImageView iv=(ImageView) findViewById(R.id.imageView);
        //final MediaPlayer miReprodctor=MediaPlayer.create(this, R.raw.muse);
        //listaMusica.add(miReprodctor);
        //final MediaPlayer miReprodctor2=MediaPlayer.create(this, R.raw.posada);
        //final MediaPlayer miReproductor3=MediaPlayer.create(this, R.raw.mago);
        //listaMusica.add(miReprodctor2);
        imagen=(ImageView) findViewById(R.id.imageView);
        final TextView nombre=(TextView) findViewById(R.id.txt1);
        vectorMusica[0]=MediaPlayer.create(this, R.raw.posada);
        vectorMusica[1]=MediaPlayer.create(this, R.raw.mago);
        vectorMusica[2]=MediaPlayer.create(this, R.raw.muse);
        vectorMusica[3]=MediaPlayer.create(this, R.raw.vida);
        vectorMusica[4]=MediaPlayer.create(this, R.raw.shrek);
        vectorNombre[0]="Mago de Oz - Posada de los muertos";
        vectorNombre[1]="Mago de Oz - Desde mi cielo";
        vectorNombre[2]="Muse - Knights of Cydonia";
        vectorNombre[3]="Calle 13 - La vida";
        vectorNombre[4]="Rufus - Hallelujah";
        final Button btnPause=(Button) findViewById(R.id.btnPausa);
        final Button btnStop=(Button) findViewById(R.id.btnStop);
        final Button btnRetroceder=(Button) findViewById(R.id.btnRetroceder);
        final Button btnSiguiente=(Button) findViewById(R.id.btnSiguiente);
         btnPlay.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                MediaPlayer alterna=new MediaPlayer();
                vectorMusica[posicion].start();
                if (vectorMusica[posicion].isPlaying()){
                    Toast mensaje= Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT);
                    mensaje.show();
                        if(posicion==0){
                            imagen.setImageResource(R.drawable.mago);
                            nom=vectorNombre[0];
                            nombre.setText(nom);
                        }else if(posicion==1){
                            imagen.setImageResource(R.drawable.mago);
                            nom=vectorNombre[1];
                            nombre.setText(nom);
                        }else if(posicion==2){
                            imagen.setImageResource(R.drawable.muse);
                            nom=vectorNombre[2];
                            nombre.setText(nom);
                        }else if(posicion==3){
                            imagen.setImageResource(R.drawable.calle13);
                            nom=vectorNombre[3];
                            nombre.setText(nom);
                        }else if(posicion==4){
                            imagen.setImageResource(R.drawable.shrek);
                            nom=vectorNombre[4];
                            nombre.setText(nom);
                        }
                        //nombre.setText(vectorNombre[posicion]);
                    } else {
                    posicion++;
                    alterna=vectorMusica[posicion];
                    alterna.start();
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_SHORT);
                    mensaje.show();
                    /*if(posicion==1){
                        imagen.setImageResource(R.drawable.mago);
                    }else if(posicion==2){
                        imagen.setImageResource(R.drawable.muse);
                    }else if(posicion==3){
                        imagen.setImageResource(R.drawable.calle13);
                    }else if(posicion==4){
                        imagen.setImageResource(R.drawable.shrek);
                    }*/
                    //nombre.setText(vectorNombre[posicion]);
                }
                /*if(miReprodctor.getDuration()==0){
                    miReprodctor.stop();
                    miReprodctor2.start();
                }*/
            }
        });
        btnPause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer alterna=new MediaPlayer();
                if(vectorMusica[posicion].isPlaying()){
                    alterna=vectorMusica[posicion];
                    alterna.pause();
                    Toast mensaje= Toast.makeText(getApplicationContext(), "Pausa", Toast.LENGTH_SHORT);
                    mensaje.show();
                    if(posicion==0){
                        imagen.setImageResource(R.drawable.mago);
                        nom=vectorNombre[0];
                        nombre.setText(nom);
                    }else if(posicion==1){
                        imagen.setImageResource(R.drawable.mago);
                        nom=vectorNombre[1];
                        nombre.setText(nom);
                    }else if(posicion==2){
                        imagen.setImageResource(R.drawable.muse);
                        nom=vectorNombre[2];
                        nombre.setText(nom);
                    }else if(posicion==3){
                        imagen.setImageResource(R.drawable.calle13);
                        nom=vectorNombre[3];
                        nombre.setText(nom);
                    }else if(posicion==4){
                        imagen.setImageResource(R.drawable.shrek);
                        nom=vectorNombre[4];
                        nombre.setText(nom);
                    }
                    //nombre.setText(vectorNombre[posicion]);
                }
            }
        });
        btnStop.setOnClickListener(new OnClickListener(){
            @Override
            public  void onClick(View v){
                vectorMusica[posicion].stop();
               if(vectorMusica[posicion] != null){
                   vectorMusica[0]=MediaPlayer.create(ReproductorActivity.this, R.raw.posada);
                   vectorMusica[1]=MediaPlayer.create(ReproductorActivity.this, R.raw.mago);
                   vectorMusica[2]=MediaPlayer.create(ReproductorActivity.this, R.raw.muse);
                   vectorMusica[3]=MediaPlayer.create(ReproductorActivity.this, R.raw.vida);
                   vectorMusica[4]=MediaPlayer.create(ReproductorActivity.this, R.raw.shrek);
                   vectorNombre[0]="Mago de Oz - Posada de los muertos";
                   vectorNombre[1]="Mago de Oz - Desde mi cielo";
                   vectorNombre[2]="Muse - Knights of Cydonia";
                   vectorNombre[3]="Calle 13 - La vida";
                   vectorNombre[4]="Rufus - Hallelujah";
                   posicion=0;
                   if(posicion==0){
                       imagen.setImageResource(R.drawable.mago);
                       nom=vectorNombre[0];
                       nombre.setText(nom);
                   }else if(posicion==1){
                       imagen.setImageResource(R.drawable.mago);
                       nom=vectorNombre[1];
                       nombre.setText(nom);
                   }else if(posicion==2){
                       imagen.setImageResource(R.drawable.muse);
                       nom=vectorNombre[2];
                       nombre.setText(nom);
                   }else if(posicion==3){
                       imagen.setImageResource(R.drawable.calle13);
                       nom=vectorNombre[3];
                       nombre.setText(nom);
                   }else if(posicion==4){
                       imagen.setImageResource(R.drawable.shrek);
                       nom=vectorNombre[4];
                       nombre.setText(nom);
                   }
                   //nombre.setText(vectorNombre[posicion]);
               }

            }
        });
        btnSiguiente.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                MediaPlayer alterna=new MediaPlayer();
                if(vectorMusica[posicion].isPlaying()){
                    vectorMusica[posicion].stop();
                    ++posicion;
                    vectorMusica[posicion].start();
                    Toast mensaje= Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_SHORT);
                    mensaje.show();
                    if(posicion==0){
                        imagen.setImageResource(R.drawable.mago);
                        nom=vectorNombre[0];
                        nombre.setText(nom);
                    }else if(posicion==1){
                        imagen.setImageResource(R.drawable.mago);
                        nom=vectorNombre[1];
                        nombre.setText(nom);
                    }else if(posicion==2){
                        imagen.setImageResource(R.drawable.muse);
                        nom=vectorNombre[2];
                        nombre.setText(nom);
                    }else if(posicion==3){
                        imagen.setImageResource(R.drawable.calle13);
                        nom=vectorNombre[3];
                        nombre.setText(nom);
                    }else if(posicion==4){
                        imagen.setImageResource(R.drawable.shrek);
                        nom=vectorNombre[4];
                        nombre.setText(nom);
                    }
                    //nombre.setText(vectorNombre[posicion]);
                }
                else {
                    posicion += 1;
                    alterna=vectorMusica[posicion];
                    alterna.start();
                    }if(posicion==0){
                    imagen.setImageResource(R.drawable.mago);
                    nom=vectorNombre[0];
                    nombre.setText(nom);
                }else if(posicion==1){
                    imagen.setImageResource(R.drawable.mago);
                    nom=vectorNombre[1];
                    nombre.setText(nom);
                }else if(posicion==2){
                    imagen.setImageResource(R.drawable.muse);
                    nom=vectorNombre[2];
                    nombre.setText(nom);
                }else if(posicion==3){
                    imagen.setImageResource(R.drawable.calle13);
                    nom=vectorNombre[3];
                    nombre.setText(nom);
                }else if(posicion==4){
                    imagen.setImageResource(R.drawable.shrek);
                    nom=vectorNombre[4];
                    nombre.setText(nom);
                }
                //nombre.setText(vectorNombre[posicion]);
                }

        })  ;
        btnRetroceder.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                MediaPlayer alterna=new MediaPlayer();
                if(vectorMusica[posicion].isPlaying()){
                    vectorMusica[posicion].stop();
                    --posicion;
                    vectorMusica[posicion].start();
                    vectorMusica[posicion].isPlaying();
                    if(posicion==0){
                        imagen.setImageResource(R.drawable.mago);
                        nom=vectorNombre[0];
                        nombre.setText(nom);
                    }else if(posicion==1){
                        imagen.setImageResource(R.drawable.mago);
                        nom=vectorNombre[1];
                        nombre.setText(nom);
                    }else if(posicion==2){
                        imagen.setImageResource(R.drawable.muse);
                        nom=vectorNombre[2];
                        nombre.setText(nom);
                    }else if(posicion==3){
                        imagen.setImageResource(R.drawable.calle13);
                        nom=vectorNombre[3];
                        nombre.setText(nom);
                    }else if(posicion==4){
                        imagen.setImageResource(R.drawable.shrek);
                        nom=vectorNombre[4];
                        nombre.setText(nom);
                    }
                    //nombre.setText(vectorNombre[posicion]);
                }
                /*else{
                    if(miReprodctor2.isPlaying()){
                        miReprodctor2.stop();
                        miReprodctor.start();
                        miReprodctor.isPlaying();
                    }
                }*/
            }
        });
    }


}
