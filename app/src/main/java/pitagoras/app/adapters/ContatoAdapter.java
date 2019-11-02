package pitagoras.app.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pitagoras.app.R;
import pitagoras.app.model.Contato;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder> {

    private Context context;
    private List<Contato> contatos;

    // controla a seleção
    private int checkedPosition = -1;

    public ContatoAdapter(Context context, List<Contato> contatos){
        this.context = context;
        this.contatos = contatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.contato_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Contato contato = contatos.get(i);
        viewHolder.txtNome.setText(contato.getNome());
        viewHolder.txtMensagem.setText(contato.getMensagem());
        viewHolder.txtHoras.setText(contato.getHoras());

        if(checkedPosition == i){
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#6bd1e8"));
        }else{
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkedPosition == i) {
                    resetSelected();
                    view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                } else {
                    checkedPosition = i;
                }
                notifyDataSetChanged();

            }
        });
    }

    public int getSelectedPositon() {
        return checkedPosition;
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    public void resetSelected() {
        checkedPosition = -1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public View view;
        public TextView txtNome;
        public TextView txtMensagem;
        public TextView txtHoras;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            this.txtNome = itemView.findViewById(R.id.contato_item_txtNome);
            this.txtMensagem = itemView.findViewById(R.id.contato_item_txtMensagem);
            this.txtHoras = itemView.findViewById(R.id.contato_item_txtHoras);
        }


    }

}
