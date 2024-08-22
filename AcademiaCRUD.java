// Integrantes: JHONY WICTOR DO NASCIMENTOS SANTOS, MAYARA DA SILVA BARBOSA
// Objetivo.: Implementar o Sistema CRUD (Creat, Read, Uptade, Delete) em uma academia que visa 
// montar treinos e dietas personalizadas para os seus alunos matriculados.

// Disciplina: PROGRAMAÇÃO ORIENTADA À OBJETOS (POO), ministrada por: TÉRCIO DE MORAIS SAMPAIO SILVA

import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    
    private int id;
    private String nome;
    private String objetivo;
    private double altura;
    private double peso;
    private String sexo;
    private double imc;

    public Aluno(int id, String nome, String objetivo, double altura, double peso, String sexo) {
        this.id = id;
        this.nome = nome;
        this.objetivo = objetivo;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        calcularIMC();
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

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getSexo() {
        return sexo;
    }

    public double getIMC() {
        return imc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        calcularIMC();
    }

    public void setPeso(double peso) {
        this.peso = peso;
        calcularIMC();
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    private void calcularIMC() {
        if (altura > 0) {
            this.imc = peso / (altura * altura);
        }
    }
}

public class AcademiaCRUD {

    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarAluno() {
        System.out.println("Digite o ID (apenas números) do aluno:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite o objetivo do aluno (a = ganhar massa muscular, b = ganhar peso, c = perder gordura, d = perder peso, e = melhorar condicionamento físico, f = tonificar):");
        String objetivo = scanner.nextLine();

        System.out.println("Digite a altura do aluno em metros ( ex: 1,75):");
        double altura = scanner.nextDouble();

        System.out.println("Digite o peso do aluno em kg ( ex: 55,2 ):");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Digite o sexo do aluno (M/F):");
        String sexo = scanner.nextLine();

        Aluno novoAluno = new Aluno(id, nome, objetivo, altura, peso, sexo);
        alunos.add(novoAluno);

        System.out.printf("Aluno adicionado com sucesso! IMC calculado: %.2f%n", novoAluno.getIMC());
    }

    public static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.printf("ID: %d, Nome: %s, Objetivo: %s, Altura: %.2f m, Peso: %.2f kg, Sexo: %s, IMC: %.2f%n", 
                    aluno.getId(), aluno.getNome(), aluno.getObjetivo(), aluno.getAltura(), aluno.getPeso(), aluno.getSexo(), aluno.getIMC());
            }
        }
    }

    public static void atualizarAluno() {
        System.out.println("Digite o ID (apenas números) do aluno que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno alunoParaAtualizar = null;
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                alunoParaAtualizar = aluno;
                break;
            }
        }

        if (alunoParaAtualizar != null) {
            System.out.println("Digite o novo nome do aluno:");
            String novoNome = scanner.nextLine();

            System.out.println("Digite o novo objetivo do aluno (a = ganhar massa muscular, b = ganhar peso, c = perder gordura, d = perder peso, e = melhorar condicionamento físico, f = tonificar):");
            String novoObjetivo = scanner.nextLine();

            System.out.println("Digite a nova altura do aluno em metros (ex: 1,75):");
            double novaAltura = scanner.nextDouble();

            System.out.println("Digite o novo peso do aluno em kg ( ex: 55,2 ):");
            double novoPeso = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o novo sexo do aluno (M/F):");
            String novoSexo = scanner.nextLine();

            alunoParaAtualizar.setNome(novoNome);
            alunoParaAtualizar.setObjetivo(novoObjetivo);
            alunoParaAtualizar.setAltura(novaAltura);
            alunoParaAtualizar.setPeso(novoPeso);
            alunoParaAtualizar.setSexo(novoSexo);

            System.out.printf("Aluno atualizado com sucesso! Novo IMC: %.2f%n", alunoParaAtualizar.getIMC());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void excluirAluno() {
        System.out.println("Digite o ID (apenas números) do aluno que deseja excluir:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno alunoParaRemover = null;
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                alunoParaRemover = aluno;
                break;
            }
        }

        if (alunoParaRemover != null) {
            alunos.remove(alunoParaRemover);
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public static void gerarPlanoExercicio(String objetivo) {
        System.out.println("\nSeu plano de exercícios:");
        
        switch (objetivo) {
            case "a":
            System.out.println("Segunda-feira (Peito e Tríceps):");
            System.out.println("1. Supino reto: 4 séries de 8-10 repetições");
            System.out.println("2. Crucifixo: 3 séries de 8 repetições");
            System.out.println("3. Tríceps testa: 3 séries de 10 repetições");
            System.out.println("Terça-feira (Costas e Bíceps):");
            System.out.println("1. Barra fixa: 4 séries de 6-8 repetições");
            System.out.println("2. Remada curvada: 3 séries de 10 repetições");
            System.out.println("3. Rosca direta: 3 séries de 12 repetições");
            System.out.println("Quarta-feira (Pernas):");
            System.out.println("1. Agachamento: 4 séries de 8 repetições");
            System.out.println("2. Leg press: 3 séries de 10 repetições");
            System.out.println("3. Cadeira extensora: 3 séries de 12 repetições");
            System.out.println("Quinta-feira (Ombros e Trapézio):");
            System.out.println("1. Desenvolvimento militar: 4 séries de 8 repetições");
            System.out.println("2. Elevação lateral: 3 séries de 12 repetições");
            System.out.println("3. Encolhimento de ombros: 3 séries de 10 repetições");
            System.out.println("Sexta-feira (Abdômen e Lombar):");
            System.out.println("1. Prancha: 3 séries de 30-60 segundos");
            System.out.println("2. Crunch: 3 séries de 15 repetições");
            System.out.println("3. Hiperextensão lombar: 3 séries de 12 repetições");
                break;

            case "b":
            System.out.println("Segunda-feira (Peito e Tríceps):");
            System.out.println("1. Supino reto: 4 séries de 8-10 repetições");
            System.out.println("2. Crucifixo: 3 séries de 12 repetições");
            System.out.println("3. Tríceps testa: 3 séries de 10 repetições");
            System.out.println("Terça-feira (Costas e Bíceps):");
            System.out.println("1. Barra fixa: 4 séries de 6-8 repetições");
            System.out.println("2. Remada curvada: 3 séries de 10 repetições");
            System.out.println("3. Rosca direta: 3 séries de 12 repetições");
            System.out.println("Quarta-feira (Pernas):");
            System.out.println("1. Agachamento: 4 séries de 8 repetições");
            System.out.println("2. Leg press: 3 séries de 10 repetições");
            System.out.println("3. Cadeira extensora: 3 séries de 12 repetições");
            System.out.println("Quinta-feira (Ombros e Trapézio):");
            System.out.println("1. Desenvolvimento militar: 4 séries de 8 repetições");
            System.out.println("2. Elevação lateral: 3 séries de 12 repetições");
            System.out.println("3. Encolhimento de ombros: 3 séries de 10 repetições");
            System.out.println("Sexta-feira (Abdômen e Lombar):");
            System.out.println("1. Prancha: 3 séries de 30-60 segundos");
            System.out.println("2. Crunch: 3 séries de 15 repetições");
            System.out.println("3. Hiperextensão lombar: 3 séries de 12 repetições");
            System.out.println("Com o tempo diminua a quantidade de repetições e aumente a carga gradativamente.");
                break;

            case "c":
                System.out.println("PERDER GORDURA:");
                System.out.println("1. Corrida na esteira: 30-45 minutos.");
                System.out.println("2. Circuito com peso corporal: 3 séries de 15 repetições.");
                System.out.println("3. HIIT (Treinamento Intervalado de Alta Intensidade): 20 minutos.");
                System.out.println("4. Abdominais: 3 séries de 20 repetições.");
                System.out.println("5. Agachamento com salto: 3 séries de 12 repetições");
                System.out.println("6. Burpees: 3 séries de 10 repetições");
                System.out.println("7. Prancha lateral: 3 séries de 30 segundos de cada lado");
                System.out.println("8. Mountain climbers: 3 séries de 20 repetições");
                break;

            case "d":
                System.out.println("PERDER PESO:");
                System.out.println("1. Elíptico ou bicicleta ergométrica: 45 minutos.");
                System.out.println("2. Treinamento funcional: 4 séries de 12 repetições.");
                System.out.println("3. Caminhada rápida: 30-45 minutos.");
                System.out.println("4. Abdominais e pranchas: 3 séries de 14 repetições.");
                System.out.println("5. Caminhada moderada: 60 minutos.");
                break;

            case "e":
                System.out.println("MELHORAR CONDICIONAMENTO FÍSICO:");
                System.out.println("1. Corrida ao ar livre ou esteira: 5 km.");
                System.out.println("2. Treinamento intervalado: 4 séries de 400 metros.");
                System.out.println("3. Exercícios pliométricos: 4 séries de 10 repetições.");
                System.out.println("4. Flexões e barras: 4 séries até a falha.");
                System.out.println("5. Kettlebell swing: 3 séries de 15 repetições");
                System.out.println("6. Bosu ball squats: 3 séries de 12 repetições");
                System.out.println("7. Jumping jacks: 3 séries de 20 repetições");
                break;

            case "f":
                System.out.println("TONIFICAR:");
                System.out.println("Segunda-feira (Peito e Tríceps):");
                System.out.println("1. Circuito de resistência: 3 séries de 15 repetições.");
                System.out.println("2. Exercícios isométricos (prancha, cadeira): 4 séries de 30 segundos.");
                System.out.println("3. Cardio leve: 20-30 minutos.");
                System.out.println("4. Exercícios com peso corporal: 3 séries de 15 repetições.");
                System.out.println("Terça-feira (Costas e Bíceps):");
                System.out.println("1. Puxada alta: 4 séries de 12 repetições");
                System.out.println("2. Rosca concentrada: 3 séries de 15 repetições");
                System.out.println("3. Supino inclinado: 4 séries de 12-15 repetições");
                System.out.println("4. Tríceps no banco: 3 séries de 12 repetições");
                System.out.println("Quarta-feira (Pernas):");
                System.out.println("1. Avanço: 3 séries de 15 repetições");
                System.out.println("2. Stiff: 3 séries de 12 repetições");
                System.out.println("3. Levantamento Terra Romeno: 4 séries de 8 repetições");
                System.out.println("4. Agachamento Frontal com Barra: 3 séries de 10 repetições");
                break;
            default:
                System.out.println("Objetivo não reconhecido.");
        }
    }

    public static void gerarPlanoDieta(String objetivo) {
        System.out.println("\nSua dieta personalizada com 6 refeições:");

        switch (objetivo) {
            case "a":
                System.out.println("GANHAR MASSA MUSCULAR:");
                System.out.println("1. Café da manhã: Aveia com banana e mel, ovos mexidos, suco de laranja.");
                System.out.println("2. Lanche da manhã: Shake de proteína, frutas secas.");
                System.out.println("3. Almoço: Frango grelhado, arroz integral, feijão, brócolis.");
                System.out.println("4. Lanche da tarde: Sanduíche de peito de peru, iogurte natural.");
                System.out.println("5. Jantar: Salmão grelhado, batata doce, espinafre.");
                System.out.println("6. Ceia: Queijo cottage, nozes.");
                break;
            case "b":
                System.out.println("GANHAR PESO:");
                System.out.println("1. Café da manhã: Pão integral com abacate, ovos mexidos, suco de laranja.");
                System.out.println("2. Lanche da manhã: Shake hipercalórico com proteína, manteiga de amendoim, banana.");
                System.out.println("3. Almoço: Carne vermelha magra, batata-doce, legumes no vapor.");
                System.out.println("4. Lanche da tarde: Barra de cereais, frutas.");
                System.out.println("5. Jantar: Macarrão com molho de carne, salada com azeite de oliva.");
                System.out.println("6. Ceia: Iogurte grego com mel, amêndoas.");
                break;
            case "c":
                System.out.println("PERDER GORDURA:");
                System.out.println("1. Café da manhã: Omelete de claras, aveia, frutas vermelhas.");
                System.out.println("2. Lanche da manhã: Frutas, iogurte light.");
                System.out.println("3. Almoço: Peito de frango grelhado, quinoa, salada verde.");
                System.out.println("4. Lanche da tarde: Shake de proteína, castanhas.");
                System.out.println("5. Jantar: Peixe grelhado, legumes cozidos no vapor.");
                System.out.println("6. Ceia: Cottage, morangos.");
                break;
            case "d":
                System.out.println("PERDER PESO:");
                System.out.println("1. Café da manhã: Smoothie de espinafre, banana, proteína.");
                System.out.println("2. Lanche da manhã: Cenouras baby, homus.");
                System.out.println("3. Almoço: Salada de atum, abacate, tomate.");
                System.out.println("4. Lanche da tarde: Mix de frutas, iogurte light.");
                System.out.println("5. Jantar: Frango grelhado, brócolis, arroz integral.");
                System.out.println("6. Ceia: Iogurte grego, sementes de chia.");
                break;
            case "e":
                System.out.println("MELHORAR CONDICIONAMENTO FÍSICO:");
                System.out.println("1. Café da manhã: Mingau de aveia com frutas, leite de amêndoas.");
                System.out.println("2. Lanche da manhã: Maçã, nozes.");
                System.out.println("3. Almoço: Peito de frango, arroz integral, salada verde.");
                System.out.println("4. Lanche da tarde: Smoothie de proteína, morangos.");
                System.out.println("5. Jantar: Carne grelhada, batata-doce, espinafre.");
                System.out.println("6. Ceia: Queijo cottage, frutas vermelhas.");
                break;
            case "f":
                System.out.println("TONIFICAR:");
                System.out.println("1. Café da manhã: Ovos mexidos, torrada integral, suco verde.");
                System.out.println("2. Lanche da manhã: Amêndoas, iogurte natural.");
                System.out.println("3. Almoço: Salmão grelhado, quinoa, salada mista.");
                System.out.println("4. Lanche da tarde: Shake de proteína, frutas vermelhas.");
                System.out.println("5. Jantar: Frango grelhado, legumes assados.");
                System.out.println("6. Ceia: Iogurte grego, mel, nozes.");
                break;
            default:
                System.out.println("Objetivo não reconhecido.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBem-vindo(a) ao seu HealthyLife, seu Sitema de Academia & Sáude Personalizados!");
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Excluir Aluno");
            System.out.println("5. Gerar Plano de Treino e Dieta");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    atualizarAluno();
                    break;
                case 4:
                    excluirAluno();
                    break;
                case 5:
                    System.out.println("Digite o ID (apenas números) do aluno para gerar o plano de treino e dieta:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Aluno alunoParaPlano = null;
                    for (Aluno aluno : alunos) {
                        if (aluno.getId() == id) {
                            alunoParaPlano = aluno;
                            break;
                        }
                    }

                    if (alunoParaPlano != null) {
                        gerarPlanoExercicio(alunoParaPlano.getObjetivo());
                        gerarPlanoDieta(alunoParaPlano.getObjetivo());
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
