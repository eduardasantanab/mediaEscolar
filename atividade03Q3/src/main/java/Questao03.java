import java.util.Scanner;

public class Questao03 {

    public static void preencheVetores(String[] nomes, double[] primeirasNotas, double[] segundasNotas, double[] medias, String[] situacaoAluno) {

        Scanner input = new Scanner(System.in);
        double calculoMedia;

        for (int i = 0; i < nomes.length; i++) {

            System.out.println("-----------------------------------------------");

            System.out.println("Informe o nome do aluno " + (i + 1) + ": ");
            nomes[i] = input.next();

            System.out.println("Informe a primeira nota do aluno " + (i + 1) + ": ");
            primeirasNotas[i] = input.nextDouble();

            System.out.println("Informe a segunda nota do aluno " + (i + 1) + ": ");
            segundasNotas[i] = input.nextDouble();

            calculoMedia = ((primeirasNotas[i] * 2) + (segundasNotas[i] * 3)) / 5;

            medias[i] = calculoMedia;

            if (medias[i] >= 7 && medias[i] <= 10) {
                situacaoAluno[i] = "aprovado";
            } else if (medias[i] < 7 && medias[i] >= 3) {
                situacaoAluno[i] = "em recuperação";
            } else {
                situacaoAluno[i] = "com nota fora da faixa de aprovação!";
            }
        }
    }

    public static String exibeResultado(String[] nomes, double[] medias, String[] situacaoAluno) {

        String resultado = "";
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("O aluno " + nomes[i] + " obteve média " +
                    medias[i] + " e está " + situacaoAluno[i]);
        }
        return resultado;
    }

    public static double calculaMedia(double[] medias) {

        double mediaTurma;
        double somaMedias = 0;
        double contador = 0;

        int i = 0;
        while (i < medias.length) {
            somaMedias = medias[i] + contador;
            contador = somaMedias;
            i++;
        }
        mediaTurma = somaMedias / medias.length;
        return mediaTurma;
    }

    public static float percentualAbaixoMedia(double[] medias, double mediaTurma) {

        double contador = 0;
        float percentual;

        for (int i = 0; i < medias.length; i++) {
            if (medias[i] < mediaTurma) {
                contador++;
            }
        }
        percentual = ((float) ((contador / medias.length) * 100));
        return percentual;
    }

    public static double maiorMedia(double[] medias) {

        double contador = 0;
        double maiorMedia = 0;

        for (int i = 0; i < medias.length; i++) {
            if (medias[i] > contador) {
                contador = medias[i];
                maiorMedia = contador;
            }
        }
        return maiorMedia;
    }

    public static void main(String[] args) {

        String[] nomes = new String[50];
        double[] primeirasNotas = new double[50];
        double[] segundasNotas = new double[50];
        double[] medias = new double[50];
        String[] situacaoAluno = new String[50];

        preencheVetores(nomes, primeirasNotas, segundasNotas, medias, situacaoAluno);
        System.out.println(exibeResultado(nomes, medias, situacaoAluno));

        System.out.println("Media da turma: " + calculaMedia(medias));

        System.out.println("Percentual de alunos com nota abaixo da média: " + percentualAbaixoMedia(medias, calculaMedia(medias)) + "%");

        System.out.println("Maior média: " + maiorMedia(medias));
    }
}
