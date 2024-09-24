import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int opt = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();
        ArrayList<Animal> animais = new ArrayList<Animal>();
        do {
            System.out.println("Opções: ");
            System.out.println("1. Cadastrar Categoria");
            System.out.println("2. Cadastrar Tutor");
            System.out.println("3. Cadastrar Animal");
            System.out.println("4. Listar Categoria");
            System.out.println("5. Listar Tutor");
            System.out.println("6. Listar Animal");
            System.out.println("7. Nome do Tutor e Descrição da categoria");
            System.out.println("8. Exit");

            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opção inválida");
                scanner.nextLine();
                continue;
            }
            switch (opt) {
                case 1:
                    System.out.println("Digite o id da categoria: ");
                    int IdCategoria = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String descricaoCategoria = scanner.next();
                    Categoria categoria = new Categoria(IdCategoria, descricaoCategoria);
                    categorias.add(categoria);
                    break;
                case 2:
                    System.out.println("Digite o id do tutor: ");
                    int IdTutor = scanner.nextInt();
                    System.out.println("Digite o nome: ");
                    String nome = scanner.next();
                    System.out.println("Digite o telefone: ");
                    String telefone = scanner.next();
                    System.out.println("Digite o email: ");
                    String email = scanner.next();
                    Tutor tutor = new Tutor(IdTutor, nome, telefone, email);
                    tutores.add(tutor);
                    break;
                case 3:
                    System.out.println("Digite o id do animal: ");
                    int IdAnimal = scanner.nextInt();
                    System.out.println("Digite o nome do animal: ");
                    String nomeAnimal = scanner.next();
                    System.out.println("Digite a raça: ");
                    String raca = scanner.next();
                    System.out.println("Digite o peso do animal: ");
                    float peso = scanner.nextFloat();
                    System.out.println("Digite o id da categoria do animal: ");
                    int IdCategoria2 = scanner.nextInt();
                    System.out.println("Digite o id d tutor do animal: ");
                    int IdTutor2 = scanner.nextInt();
                    Animal animal = new Animal(IdAnimal, nomeAnimal, raca, peso, IdCategoria2, IdTutor2);
                    animais.add(animal);
                    break;
                case 4:
                    for (Categoria categoriaPrint : categorias) {
                        int qtdAnimais = 0;
                        for (Animal animalPrint : animais) {
                            if (animalPrint.IdCategoria == categoriaPrint.IdCategoria) {
                                qtdAnimais++;
                            }
                        }
                        System.out.println("Categoria: " + categoriaPrint.descricaoCategoria
                                + " - Quantidade de Animais: " + qtdAnimais);
                    }
                    break;
                case 5:

                    for (Tutor tutorPrint : tutores) {
                        int qtdAnimaisPorTutor = 0;
                        for (Animal animalPrint : animais) {
                            if (animalPrint.IdTutor == tutorPrint.IdTutor) {
                                qtdAnimaisPorTutor++;
                            }
                        }
                        System.out.println(
                                "Tutor: " + tutorPrint.nomeTutor + " - Quantidade de Animais: " + qtdAnimaisPorTutor);
                    }
                    break;
                case 6:

                    for (Animal animalPrint : animais) {
                        System.out.println("Animal: " + animalPrint.nomeAnimal + " - Raça: " + animalPrint.raca);
                    }
                    break;

                case 7:

                    for (Animal animalPrint : animais) {
                        Tutor tutorAnimal = null;
                        Categoria categoriaAnimal = null;

                        for (Tutor tut : tutores) {
                            if (tut.IdTutor == animalPrint.IdTutor) {
                                tutorAnimal = tut;
                                break;
                            }
                        }

                        for (Categoria categoriaPrint : categorias) {
                            if (categoriaPrint.IdCategoria == animalPrint.IdCategoria) {
                                categoriaAnimal = categoriaPrint;
                                break;
                            }
                        }
                        if (tutorAnimal != null && categoriaAnimal != null) {
                            System.out.println("Animal: " + animalPrint.nomeAnimal + " - Tutor: "
                                    + tutorAnimal.nomeTutor + " - Categoria: " + categoriaAnimal.descricaoCategoria);
                        } else {
                            System.out.println(
                                    "Tutor ou Categoria não encontrados para o animal: " + animalPrint.nomeAnimal);
                        }
                    }
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
            }
        } while (opt != 8);

        scanner.close();
    }
}
