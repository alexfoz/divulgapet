const db = require("../firebaseConfig");
const Tutor = require("../Tutor");

class TutorDAO {
    constructor() {
        this.tutorRef = db.ref("tutor");
    }

    async adicionarTutor(tutor) {
        try {
            const novoTutorRef = this.tutorRef.push();
            await novoTutorRef.set({
                nome: tutor.getNome(),
                telefone: tutor.getTelefone(),
                email: tutor.getEmail(),
                status: tutor.getStatus()
            });
            console.log("Tutor adicionado com sucesso!");
        } catch (error) {
            console.error("Erro ao adicionar o tutor: ", error);
        }
    }

    async atualizarTutor(id, tutor) {
        try {
            await this.tutorRef.child(id).update({
                nome: tutor.getNome(),
                telefone: tutor.getTelefone(),
                email: tutor.getEmail(),
                status: tutor.getStatus()
            });
            console.log("Tutor atualizado com sucesso!");
        } catch (error) {
            console.error("Erro ao atualizar o tutor: ", error);
        }
    }

    async removerTutor(id) {
        try {
            await this.tutorRef.child(id).remove();
            console.log("Tutor removido com sucesso!");
        } catch (error) {
            console.error("Erro ao remover o tutor: ", error);
        }
    }

    async obterTodosTutores() {
        try {
            const snapshot = await this.tutorRef.once("value");
            snapshot.forEach((childSnapshot) => {
                const tutor = new Tutor(
                    childSnapshot.val().nome,
                    childSnapshot.val().telefone,
                    childSnapshot.val().email,
                    childSnapshot.val().status
                );
                console.log(tutor);
            });
        } catch (error) {
            console.error("Erro ao obter todos os tutores: ", error);
        }
    }
}

module.exports = TutorDAO;