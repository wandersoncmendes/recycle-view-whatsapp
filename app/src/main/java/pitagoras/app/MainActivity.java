package pitagoras.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import pitagoras.app.adapters.ContatoAdapter;
import pitagoras.app.model.Contato;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    private Button btnAdd;
    private Button btnRemove;

    //private ContatoAdapter adapter;
    private List<Contato> contatos;
    private ContatoAdapter adapter;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contatos = new ArrayList<>();
        contatos.add(new Contato("fulano", "teste", "20:00"));
        contatos.add(new Contato("beltrano", "mensagem legal", "15:00"));
        contatos.add(new Contato("ciclano", "teste novamente", "23:00"));

        adapter = new ContatoAdapter(this, contatos);

        rv = findViewById(R.id.rv_contatos);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        btnAdd = findViewById(R.id.add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contatos.add(getRandomElement());
                adapter.notifyDataSetChanged();
            }
        });

        btnRemove = findViewById(R.id.remove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = adapter.getSelectedPositon();
                if(position == -1) {
                    Toast.makeText(MainActivity.this, "Nenhum item selecionado!", Toast.LENGTH_SHORT).show();
                } else {
                    contatos.remove(position);
                    adapter.notifyDataSetChanged();
                    adapter.resetSelected();
                }
            }
        });

    }

    public Contato getRandomElement() {
        Contato contato = contatos.get(random.nextInt(contatos.size()));

        //Hora atual do sistema
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        contato.setHoras(sdf.format(date));

        return contato;
    }
}
