package mx.nitrogena.dadm.mod4.nim4practica2.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.DetalleActivity;
import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;
import mx.nitrogena.dadm.mod4.nim4practica2.R;

/**
 * Created by Nidia on 21/07/2016.
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder>{
    ArrayList<AppModel> arrLstAppMdl;
    Activity activity;

    //Constructor
    public AppAdapter(ArrayList<AppModel> arrLstAppMdl, Activity activity){
        this.arrLstAppMdl = arrLstAppMdl;
        this.activity = activity;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar o darle vida al cardview_app.xml, asociandolo con el recycler
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_app, parent, false);

        //pasamos  el layout inflado, al constructor para que se obtenga cada elemento que compone el layout (views)
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        //asocia cada elemento de la lista con el view
        //se pasa lista de contactos a cada elemento, con set,
        //se invoca para cada uno de los elementos de la lista
        //obtiene el objeto del que está interando
        final AppModel regAppModel = arrLstAppMdl.get(position);

        boolean blnBandera = !(position%2 == 0);
        final int intImgApp = blnBandera ? R.drawable.sh_sm_img : R.drawable.ba_1;

        //holder.ivImgApp.setImageResource(regAppModel.getIntImgApp());
        holder.ivImgApp.setImageResource(intImgApp);

        if (regAppModel.getStrInstalada().toString() == "si"){
            holder.tvInstalada.setText(R.string.cvapp_tv_instalada);
        }
        else{
            holder.tvInstalada.setText(R.string.cvapp_tv_noInstalada);
        }
        //holder.tvInstalada.setText(regAppModel.getStrInstalada());
        holder.tvCalifica.setText(regAppModel.getStrCalifica());
        holder.tvAutor.setText(regAppModel.getStrDesarrollador());
        holder.tvTitulo.setText(regAppModel.getStrNombreApp());

        holder.cvCv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, regAppModel.getStrNombreApp(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, DetalleActivity.class);
                intent.putExtra("NombreApp", regAppModel.getStrNombreApp());
                intent.putExtra("Desarrollador", regAppModel.getStrDesarrollador());
                intent.putExtra("ImgApp", regAppModel.getIntImgApp());
                intent.putExtra("Calificacion", regAppModel.getStrCalifica());
                intent.putExtra("Instalada", regAppModel.getStrInstalada());
                intent.putExtra("Like", regAppModel.getIntLike());
                //se pueden enviar arreglos de strings
                activity.startActivity(intent);
                //PARA TENER SOLO UNA ACTIVIDAD EN EL STACK
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        //CANTIDAD DE ELEMENTOS QUE TIENE LA LISTA
        //return 0;
        return arrLstAppMdl.size();
    }

    //PASAR LOS DATOS A LOS ELEMENTOS, RECIBE UNA COLECCION DE AppViewHolder
    //se generan varias tarjetas



    //Crear views y asociarlos a sus equivalentes objetos
    public static class AppViewHolder extends RecyclerView.ViewHolder {



        private ImageView ivImgApp;     //OBJETO
        private TextView tvTitulo;
        private TextView tvAutor;
        private TextView tvCalifica;
        private TextView tvInstalada;
        private CardView cvCv;

        public AppViewHolder(View itemView) {
            super(itemView);

            //Declarar todos los views del cardview (cardview_app.xml)

            ivImgApp = (ImageView) itemView.findViewById(R.id.cvapp_iv_imgApp);
            tvTitulo = (TextView) itemView.findViewById(R.id.cvapp_tv_titulo);
            tvAutor = (TextView) itemView.findViewById(R.id.cvapp_tv_autor);
            tvCalifica = (TextView) itemView.findViewById(R.id.cvapp_tv_califica);
            tvInstalada = (TextView) itemView.findViewById(R.id.cvapp_tv_instalada);

            cvCv = (CardView) itemView.findViewById(R.id.cvapp_cv);
        }
    }

}
