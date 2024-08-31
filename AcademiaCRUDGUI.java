import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Aluno {
    private int id;
    private String nome;
    private String objetivo;
    

    public Aluno(int id, String nome, String objetivo) {
        this.id = id;
        this.nome = nome;
        this.objetivo = objetivo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}

public class AcademiaCRUDGUI {
    private JFrame frame;
    private JTextField txtId, txtNome, txtObjetivo;
    private JTextArea textArea;
    private ArrayList<Aluno> alunos;
    private JTextArea txtObjetivoInfo;

    public AcademiaCRUDGUI() {
        alunos = new ArrayList<>();
        frame = new JFrame("HealtlyLife: Treinos & Dietas Personalizadas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600); // Ajustado para incluir o novo texto
        frame.setLayout(new BorderLayout());

        // Panel de entrada de dados do aluno
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));

        txtId = new JTextField();
        txtNome = new JTextField();
        txtObjetivo = new JTextField();

        inputPanel.add(new JLabel("ID (apenas números):"));
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(txtNome);
        inputPanel.add(new JLabel("Objetivo (a-f):"));
        inputPanel.add(txtObjetivo);

        // Área de texto com informações dos objetivos
        txtObjetivoInfo = new JTextArea(5, 40);
        txtObjetivoInfo.setEditable(false);
        txtObjetivoInfo.setText("Lembre-se dos objetivos:\n" +
                                "a = Ganhar Massa Muscular\n" +
                                "b = Ganhar Peso\n" +
                                "c = Perder Gordura\n" +
                                "d = Perder Peso\n" +
                                "e = Melhorar Condicionamento Físico\n" +
                                "f = Tonificar\n");
        JScrollPane scrollPaneObjetivo = new JScrollPane(txtObjetivoInfo);
        scrollPaneObjetivo.setBorder(BorderFactory.createTitledBorder("Descrição dos Objetivos"));

        // Botões
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton btnAdicionar = new JButton("Adicionar Usuário(a)");
        JButton btnListar = new JButton("Listar Usuários(as)");
        JButton btnAtualizar = new JButton("Atualizar Dados");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnPlano = new JButton("Gerar Plano");

        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnListar);
        buttonPanel.add(btnAtualizar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnPlano);

        // Área de texto para exibir informações
        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Saída"));

        // Adicionando componentes ao frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.add(scrollPaneObjetivo, BorderLayout.EAST);

        // Ações dos botões
        btnAdicionar.addActionListener(e -> adicionarAluno());
        btnListar.addActionListener(e -> listarAlunos());
        btnAtualizar.addActionListener(e -> atualizarAluno());
        btnExcluir.addActionListener(e -> excluirAluno());
        btnPlano.addActionListener(e -> gerarPlano());

        frame.setVisible(true);
    }

    private void adicionarAluno() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String objetivo = txtObjetivo.getText();
            Aluno novoAluno = new Aluno(id, nome, objetivo);
            alunos.add(novoAluno);
            textArea.append("Aluno adicionado com sucesso!\n");
        } catch (NumberFormatException ex) {
            textArea.append("ID inválido. Por favor, insira um número.\n");
        }
    }

    private void listarAlunos() {
        if (alunos.isEmpty()) {
            textArea.append("Nenhum aluno cadastrado.\n");
        } else {
            for (Aluno aluno : alunos) {
                textArea.append("ID: " + aluno.getId() + ", Nome: " + aluno.getNome() + ", Objetivo: " + aluno.getObjetivo() + "\n");
            }
        }
    }

    private void atualizarAluno() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Aluno alunoParaAtualizar = null;
            for (Aluno aluno : alunos) {
                if (aluno.getId() == id) {
                    alunoParaAtualizar = aluno;
                    break;
                }
            }
            if (alunoParaAtualizar != null) {
                alunoParaAtualizar.setNome(txtNome.getText());
                alunoParaAtualizar.setObjetivo(txtObjetivo.getText());
                textArea.append("Aluno atualizado com sucesso!\n");
            } else {
                textArea.append("Aluno não encontrado.\n");
            }
        } catch (NumberFormatException ex) {
            textArea.append("ID inválido. Por favor, insira um número.\n");
        }
    }

    private void excluirAluno() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Aluno alunoParaRemover = null;
            for (Aluno aluno : alunos) {
                if (aluno.getId() == id) {
                    alunoParaRemover = aluno;
                    break;
                }
            }
            if (alunoParaRemover != null) {
                alunos.remove(alunoParaRemover);
                textArea.append("Aluno excluído com sucesso!\n");
            } else {
                textArea.append("Aluno não encontrado.\n");
            }
        } catch (NumberFormatException ex) {
            textArea.append("ID inválido. Por favor, insira um número.\n");
        }
    }

    private void gerarPlano() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Aluno alunoParaPlano = null;
            for (Aluno aluno : alunos) {
                if (aluno.getId() == id) {
                    alunoParaPlano = aluno;
                    break;
                }
            }
            if (alunoParaPlano != null) {
                textArea.append("\nPlano Personalizado para " + alunoParaPlano.getNome() + ":\n");
                gerarPlanoExercicio(alunoParaPlano.getObjetivo());
                gerarPlanoDieta(alunoParaPlano.getObjetivo());
            } else {
                textArea.append("Aluno não encontrado.\n");
            }
        } catch (NumberFormatException ex) {
            textArea.append("ID inválido. Por favor, insira um número.\n");
        }
    }

    private void gerarPlanoExercicio(String objetivo) {
        textArea.append("\nPlano de Exercícios:\n");
        switch (objetivo.toLowerCase()) {
            case "a":
                textArea.append("Objetivo: Hipertrofia Muscular\n");
                textArea.append("Segunda-feira (Peito e Tríceps):\n");
                textArea.append("1. Supino reto: 4 séries de 8-10 repetições\n");
                textArea.append("2. Crucifixo: 3 séries de 8 repetições\n");
                textArea.append("3. Tríceps testa: 3 séries de 10 repetições\n");
                textArea.append("Terça-feira (Costas e Bíceps):\n");
                textArea.append("1. Barra fixa: 4 séries de 6-8 repetições\n");
                textArea.append("2. Remada curvada: 3 séries de 10 repetições\n");
                textArea.append("3. Rosca direta: 3 séries de 12 repetições\n");
                textArea.append("Quarta-feira (Pernas):\n");
                textArea.append("1. Agachamento: 4 séries de 8 repetições\n");
                textArea.append("2. Leg press: 3 séries de 10 repetições\n");
                textArea.append("3. Cadeira extensora: 3 séries de 12 repetições\n");
                textArea.append("Quinta-feira (Ombros e Trapézio):\n");
                textArea.append("1. Desenvolvimento militar: 4 séries de 8 repetições\n");
                textArea.append("2. Elevação lateral: 3 séries de 12 repetições\n");
                textArea.append("3. Encolhimento de ombros: 3 séries de 10 repetições\n");
                textArea.append("Sexta-feira (Abdômen e Lombar):\n");
                textArea.append("1. Prancha: 3 séries de 30-60 segundos\n");
                textArea.append("2. Crunch: 3 séries de 15 repetições\n");
                textArea.append("3. Hiperextensão lombar: 3 séries de 12 repetições\n");
                break;
            case "b":
                textArea.append("Objetivo: Ganho de Peso\n");
                textArea.append("Segunda-feira (Peito e Tríceps):\n");
                textArea.append("1. Supino reto: 5 séries de 6-8 repetições\n");
                textArea.append("2. Crucifixo inclinado: 4 séries de 8 repetições\n");
                textArea.append("3. Tríceps mergulho: 4 séries de 10 repetições\n");
                textArea.append("Terça-feira (Costas e Bíceps):\n");
                textArea.append("1. Remada com barra: 4 séries de 8 repetições\n");
                textArea.append("2. Puxada na frente: 4 séries de 10 repetições\n");
                textArea.append("3. Rosca alternada: 4 séries de 12 repetições\n");
                textArea.append("Quarta-feira (Pernas):\n");
                textArea.append("1. Agachamento frontal: 5 séries de 8 repetições\n");
                textArea.append("2. Avanço: 4 séries de 10 repetições\n");
                textArea.append("3. Stiff: 4 séries de 12 repetições\n");
                textArea.append("Quinta-feira (Ombros e Trapézio):\n");
                textArea.append("1. Desenvolvimento com halteres: 4 séries de 8 repetições\n");
                textArea.append("2. Elevação frontal: 4 séries de 10 repetições\n");
                textArea.append("3. Encolhimento com halteres: 4 séries de 12 repetições\n");
                textArea.append("Sexta-feira (Abdômen e Lombar):\n");
                textArea.append("1. Abdominal com carga: 3 séries de 15 repetições\n");
                textArea.append("2. Elevação de pernas: 3 séries de 12 repetições\n");
                textArea.append("3. Hiperextensão: 3 séries de 15 repetições\n");
                break;
            case "c":
                textArea.append("Objetivo: Perda de Gordura\n");
                textArea.append("Segunda-feira (Treino Cardio):\n");
                textArea.append("1. Corrida: 30 minutos\n");
                textArea.append("2. Pular corda: 15 minutos\n");
                textArea.append("Terça-feira (Treino de Força - Corpo Inteiro):\n");
                textArea.append("1. Agachamento com peso corporal: 3 séries de 15 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 12 repetições\n");
                textArea.append("3. Remada com elástico: 3 séries de 15 repetições\n");
                textArea.append("Quarta-feira (Treino Cardio):\n");
                textArea.append("1. Bicicleta ergométrica: 30 minutos\n");
                textArea.append("2. HIIT: 15 minutos\n");
                textArea.append("Quinta-feira (Treino de Força - Corpo Inteiro):\n");
                textArea.append("1. Levantamento terra com peso corporal: 3 séries de 15 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 12 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 20 repetições\n");
                textArea.append("Sexta-feira (Treino Cardio):\n");
                textArea.append("1. Corrida: 30 minutos\n");
                textArea.append("2. HIIT: 15 minutos\n");
                break;
            case "d":
                textArea.append("Objetivo: Perda de Peso\n");
                textArea.append("Segunda-feira (Cardio + Força):\n");
                textArea.append("1. Corrida leve: 20 minutos\n");
                textArea.append("2. Treino de força (agachamento, flexões, abdominais): 3 séries de 12 repetições\n");
                textArea.append("Terça-feira (Cardio Intenso):\n");
                textArea.append("1. HIIT: 20 minutos\n");
                textArea.append("Quarta-feira (Treino de Força - Corpo Inteiro):\n");
                textArea.append("1. Agachamento com peso corporal: 3 séries de 12 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 12 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 15 repetições\n");
                textArea.append("Quinta-feira (Cardio):\n");
                textArea.append("1. Bicicleta: 30 minutos\n");
                textArea.append("Sexta-feira (Treino de Força - Corpo Inteiro):\n");
                textArea.append("1. Levantamento terra com peso corporal: 3 séries de 12 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 12 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 15 repetições\n");
                break;
            case "e":
                textArea.append("Objetivo: Melhorar Condicionamento Físico\n");
                textArea.append("Segunda-feira (Cardio + Força):\n");
                textArea.append("1. Corrida: 20 minutos\n");
                textArea.append("2. Treino de força (agachamento, flexões, abdominais): 3 séries de 12 repetições\n");
                textArea.append("Terça-feira (Cardio Intenso):\n");
                textArea.append("1. HIIT: 20 minutos\n");
                textArea.append("Quarta-feira (Treino de Força - Corpo Inteiro):\n");
                textArea.append("1. Agachamento com peso corporal: 3 séries de 12 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 12 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 15 repetições\n");
                textArea.append("Quinta-feira (Cardio):\n");
                textArea.append("1. Bicicleta: 30 minutos\n");
                textArea.append("Sexta-feira (Treino de Força - Corpo Inteiro):\n");
                textArea.append("1. Levantamento terra com peso corporal: 3 séries de 12 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 12 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 15 repetições\n");
                break;
            case "f":
                textArea.append("Objetivo: Tonificar\n");
                textArea.append("Segunda-feira (Treino de Tonificação):\n");
                textArea.append("1. Agachamento: 3 séries de 15 repetições\n");
                textArea.append("2. Flexão de braço: 3 séries de 15 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 20 repetições\n");
                textArea.append("Terça-feira (Cardio Leve):\n");
                textArea.append("1. Caminhada rápida: 30 minutos\n");
                textArea.append("Quarta-feira (Treino de Tonificação):\n");
                textArea.append("1. Afundo: 3 séries de 15 repetições\n");
                textArea.append("2. Elevação de quadril: 3 séries de 15 repetições\n");
                textArea.append("3. Abdominal oblíquo: 3 séries de 20 repetições\n");
                textArea.append("Quinta-feira (Cardio Leve):\n");
                textArea.append("1. Bicicleta: 30 minutos\n");
                textArea.append("Sexta-feira (Treino de Tonificação):\n");
                textArea.append("1. Supino reto: 3 séries de 15 repetições\n");
                textArea.append("2. Remada curvada: 3 séries de 15 repetições\n");
                textArea.append("3. Abdominal: 3 séries de 20 repetições\n");
                break;
            default:
                textArea.append("Objetivo inválido.\n");
                break;
        }
    }

    private void gerarPlanoDieta(String objetivo) {
        textArea.append("\nPlano de Dieta:\n");
        switch (objetivo.toLowerCase()) {
            case "a":
                textArea.append("1. Café da manhã: Omelete com vegetais e aveia\n");
                textArea.append("2. Almoço: Frango grelhado com arroz integral e brócolis\n");
                textArea.append("3. Jantar: Salmão assado com batata doce\n");
                textArea.append("4. Lanches: Shake de proteína e nozes\n");
                break;
            case "b":
                textArea.append("1. Café da manhã: Panquecas de aveia com mel\n");
                textArea.append("2. Almoço: Hambúrguer de carne magra com batata assada\n");
                textArea.append("3. Jantar: Frango ao molho com arroz\n");
                textArea.append("4. Lanches: Barras de proteína e frutas\n");
                break;
            case "c":
                textArea.append("1. Café da manhã: Smoothie verde com espinafre e maçã\n");
                textArea.append("2. Almoço: Salada de atum com vegetais variados\n");
                textArea.append("3. Jantar: Peixe grelhado com legumes\n");
                textArea.append("4. Lanches: Iogurte grego e frutas vermelhas\n");
                break;
            case "d":
                textArea.append("1. Café da manhã: Mingau de aveia com frutas\n");
                textArea.append("2. Almoço: Peito de frango grelhado com quinoa\n");
                textArea.append("3. Jantar: Carne magra com legumes no vapor\n");
                textArea.append("4. Lanches: Frutas e nozes\n");
                break;
            case "e":
                textArea.append("1. Café da manhã: Granola com iogurte e frutas\n");
                textArea.append("2. Almoço: Salada de grão-de-bico com vegetais\n");
                textArea.append("3. Jantar: Frango grelhado com batata doce\n");
                textArea.append("4. Lanches: Shake de proteína e frutas\n");
                break;
            case "f":
                textArea.append("1. Café da manhã: Smoothie de proteína com frutas\n");
                textArea.append("2. Almoço: Salada com peito de frango e abacate\n");
                textArea.append("3. Jantar: Peixe assado com legumes\n");
                textArea.append("4. Lanches: Iogurte e frutas secas\n");
                break;
            default:
                textArea.append("Objetivo inválido.\n");
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AcademiaCRUDGUI::new);
    }
}
