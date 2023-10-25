package com.example.exercicio1;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UsuarioDAO {
    private DatabaseReference usuarioRef;

    public UsuarioDAO() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        usuarioRef = database.getReference("usuario");
    }

    public void adicionarUsuario(Usuario usuario) {
        try {
            DatabaseReference novoUsuarioRef = usuarioRef.push();
            novoUsuarioRef.setValue(usuario);
            System.out.println("Usuario adicionado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao adicionar o usuario: " + e.getMessage());
        }
    }

    public void atualizarUsuario(String id, Usuario usuario) {
        try {
            usuarioRef.child(id).setValue(usuario);
            System.out.println("Usuario atualizado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o usuario: " + e.getMessage());
        }
    }

    public void removerUsuario(String id) {
        try {
            usuarioRef.child(id).removeValue();
            System.out.println("Usuario removido com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao remover o usuario: " + e.getMessage());
        }
    }

    public void obterTodosUsuarioes() {
        try {
            usuarioRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        Usuario usuario = childSnapshot.getValue(Usuario.class);
                        System.out.println(usuario);
                    }
                }

                /*@Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
*/
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.err.println("Erro ao obter todos os usuarios: " + databaseError.getMessage());
                }
            });
        } catch (Exception e) {
            System.err.println("Erro ao obter todos os usuarios: " + e.getMessage());
        }
    }
}
