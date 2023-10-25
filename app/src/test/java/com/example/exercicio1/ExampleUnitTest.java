package com.example.exercicio1;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ExampleUnitTest extends AppCompatActivity {
    private DatabaseReference usuarioRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        usuarioRef = database.getReference("usuario");

        // Teste de adição de um novo usuarios
        Usuario novoUsuario = new Usuario("João", "123456789", "joao@email.com", 1);
        adicionarUsuario(novoUsuario);

        // Teste de atualização de um usuarios existente (suponha que você saiba o ID do usuarios)
        Usuario usuarioAtualizado = new Usuario("João da Silva", "987654321", "joao.silva@email.com", 2);
        String idUsuario = "1"; // Substitua pelo ID real do usuarios a ser atualizado
        atualizarUsuario(idUsuario, usuarioAtualizado);

        // Teste de remoção de um usuarios (suponha que você saiba o ID do usuarios)
        String idUsuarioRemover = "-MhYtJUcdosqwldmklasd"; // Substitua pelo ID real do usuarios a ser removido
        removerUsuario(idUsuarioRemover);

        // Teste de obtenção de todos os usuarioses
        obterTodosUsuarioes();
    }


    private void adicionarUsuario(Usuario usuarios) {
        DatabaseReference Usuario = null;
        DatabaseReference usuariosRef = Usuario;
        DatabaseReference novoUsuarioRef = usuariosRef.push();
        novoUsuarioRef.setValue(Usuario);
    }

    private void atualizarUsuario(String id, Usuario usuarios) {
        usuarioRef.child(id).setValue(usuarios);
    }

    private void removerUsuario(String id) {
        usuarioRef.child(id).removeValue();
    }

    private void obterTodosUsuarioes() {
        usuarioRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    Usuario usuarios = childSnapshot.getValue(Usuario.class);
                    // Faça algo com o usuarios obtido, como exibi-lo na interface do usuário
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Lidar com erros, se houver algum
            }
        });
    }
}




/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="hhttps://exercicio-1-bd359-default-rtdb.firebaseio.com">Testing documentation</a>
 */
/*public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}
 */

