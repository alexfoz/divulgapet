class Tutor {
    constructor(nome, telefone, email, status) {
        this.nome = nome
        this.telefone = telefone
        this.status = status

        if (email == null || email == "") {
            this.email = "Não informado."
        
        } else {
            this.email = email
        }
    }

    getNome() {
        return this.nome
    }

    setNome(nome) {
        this.nome = nome
    }

    getTelefone() {
        return this.telefone
    }

    setTelefone(telefone) {
        this.telefone = telefone
    }

    getEmail() {
        return this.email
    }

    setEmail(email = null) {
        if (email == null || email == "") {
            this.email = "Não informado"
        
        } else {
            this.email = email
        }
    }

    getStatus() {
        return this.status
    }

    setStatus(status) {
        this.status = status
    }
}

module.exports = Tutor;