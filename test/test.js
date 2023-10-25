const TutorDAO = require('./DAOs/TutorDAO');
const Tutor = require('./Tutor');

const tutorDAO = new TutorDAO();

// Teste de adição de um novo tutor
const novoTutor = new Tutor("João", "123456789", "joao@email.com", 1);
tutorDAO.adicionarTutor(novoTutor);

// Teste de atualização de um tutor existente (suponha que você saiba o ID do tutor)
const tutorAtualizado = new Tutor("João da Silva", "987654321", "joao.silva@email.com", 2);
const idTutor = "-MhYtJUcdosqwldmklasd"; // Substitua pelo ID real do tutor a ser atualizado
tutorDAO.atualizarTutor(idTutor, tutorAtualizado);

// Teste de remoção de um tutor (suponha que você saiba o ID do tutor)
const idTutorRemover = "-MhYtJUcdosqwldmklasd"; // Substitua pelo ID real do tutor a ser removido
tutorDAO.removerTutor(idTutorRemover);

// Teste de obtenção de todos os tutores
tutorDAO.obterTodosTutores();