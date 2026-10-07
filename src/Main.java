import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    List<Pessoa> banco = new ArrayList<>();

    banco.add(new Pessoa("Changbin", 17, 67));
    banco.add(new Pessoa("Engfa", 24, 10));
    banco.add(new Pessoa("Wumuti", 20, 9));
    banco.add(new Pessoa("Bangchan", 18, 8));
    banco.add(new Pessoa("Sophia", 17, 7));

    List<Pessoa> cache = new ArrayList<>();


    while (true) {
        IO.println("\nDigite o ID (ou 13 para sair):");
        int id = scanner.nextInt();

        if (id == -13) break;

        Pessoa encontrada = null;


        for (Pessoa pessoa : cache) {
            if (pessoa.getId() == id) {
                encontrada = pessoa;
                break;
            }
        }

        if (encontrada != null) {
            IO.println("Pessoa encontrada no cache: " + encontrada);
        } else {

            for (Pessoa pessoa : banco) {
                if (pessoa.getId() == id) {
                    encontrada = pessoa;
                    break;
                }
            }

            if (encontrada != null) {
                if (cache.size() >= 10) {
                    cache.removeFirst();
                }
                cache.add(encontrada);
                IO.println("Pessoa buscada no banco e adicionada ao cache: " + encontrada);
            } else {
                IO.println("Pessoa não encontrada.");
            }
        }
    }
}