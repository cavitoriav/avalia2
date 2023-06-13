import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.ProviderNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;

public class App {
    private static final LocalDate LocalDate = null;

    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        int opcao;
        Scanner in = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList<>();
        List<Venda> listaVendas = new ArrayList<>();

        do {
            System.out.println("\n**\nMENU\n**\n");
            System.out.println("1- Incluir produto");
            System.out.println("2- Consultar produto");
            System.out.println("3- Listagem de produtos");
            System.out.println("4- Vendas por produtos");
            System.out.println("5- Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                System.out.println("Digite o nome do produto: ");
                String nome = in.next();
                System.out.println("Informe o código do produto ");
                String codigo = in.next();
                System.out.println("Informe o preço do produto: ");
                Double preco = in.nextDouble();
                System.out.println("Informe a quantidade do estoque: ");
                int estoque = in.nextInt();

                listaProdutos.add(new Produto(codigo, nome, preco, estoque));

                System.out.println("Produto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
            System.out.println("Informe o código do produto");
            String codigoInformado = in.next();
            List<Produto> novaLista = listaProdutos.stream()
            .filter(v -> v .getCodigo().equals(codigoInformado)).collect(Collectors.toList());
                
             if (novaLista.isEmpty()) {
             System.out.println("Produto não localizado!");

           } 
           for (Produto produto : novaLista) {
                    System.out.println(produto);  
                 }

            voltarMenu(in);
        
            } else if (opcao == 3) {
                for (Produto produto : listaProdutos) {
                    System.out.println(produto);
                }
            System.out.println("Valor médio, máximo e mínimo dos produtos:");
             DoubleSummaryStatistics resumo = listaProdutos.stream()
             .collect(Collectors.summarizingDouble(Produto::getPrice));
            System.out.printf("Médio: %.2f - Máximo: %.2f - Mínimo: %.2f",
            resumo.getAverage(), resumo.getMax(), resumo.getMin());
                
                voltarMenu(in);

             } else if (opcao == 4) {
        
            }else if (opcao == 5) {
                
                
                System.out.println("Informe o código do produto:");
                String codigoInformado = in.next();
                List<Produto> novaLista = listaProdutos.stream()
                .filter(v -> v .getCodigo().equals(codigoInformado)).collect(Collectors.toList());
                
                if (novaLista.isEmpty()) {
                    System.out.println("Produto não localizado!");
                } else {
                    System.out.println("Informe a data: [dd/mm/aaaa]");
                    String dataDaVenda = in.next();
                    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	                java.util.Date format = f.parse(dataDaVenda);
                    System.out.println("Informe quantas unidades foram vendidas:");
                    int qtdVendida = in.nextInt();
                    Produto produto = novaLista.get(0);
                    Venda venda = new Venda(produto, qtdVendida, LocalDate);
                    listaVendas.add(venda);
                    produto.setQtd(produto.getQtd() - qtdVendida);

                    System.out.println("Venda Realizada com SUCESSO!");



                }
        
                voltarMenu(in);

             }
             else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
