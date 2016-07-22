package mx.nitrogena.dadm.mod4.nim4practica2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;
import mx.nitrogena.dadm.mod4.nim4practica2.R;

/**
 * Created by Nidia on 21/07/2016.
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder>{
    ArrayList<AppModel> arrLstAppMdl;

    //Constructor
    public AppAdapter(ArrayList<AppModel> arrLstAppMdl){
        this.arrLstAppMdl = arrLstAppMdl;
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
        AppModel regAppModel = arrLstAppMdl.get(position);

        boolean blnBandera = !(position%2 == 0);
        final int intImgApp = blnBandera ? R.drawable.sh_sm_img : R.drawable.ba_1;

        //holder.ivImgApp.setImageResource(regAppModel.getIntImgApp());
        holder.ivImgApp.setImageResource(intImgApp);

        if (regAppModel.getStrInstalada().toString() == "si"){
            holder.tvInstalada.setText("INSTALADA");
        }
        else{
            holder.tvInstalada.setText("NO INSTALADA");
        }


        //holder.tvInstalada.setText(regAppModel.getStrInstalada());
        holder.tvCalifica.setText(regAppModel.getStrCalifica());
        holder.tvAutor.setText(regAppModel.getStrDesarrollador());
        holder.tvTitulo.setText(regAppModel.getStrNombreApp());


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

        public AppViewHolder(View itemView) {
            super(itemView);

            //Declarar todos los views del cardview (cardview_app.xml)

            ivImgApp = (ImageView) itemView.findViewById(R.id.cvapp_iv_imgApp);
            tvTitulo = (TextView) itemView.findViewById(R.id.cvapp_tv_titulo);
            tvAutor = (TextView) itemView.findViewById(R.id.cvapp_tv_autor);
            tvCalifica = (TextView) itemView.findViewById(R.id.cvapp_tv_califica);
            tvInstalada = (TextView) itemView.findViewById(R.id.cvapp_tv_instalada);
        }
    }

}
