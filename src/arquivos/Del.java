
package arquivos;

import java.io.File;
import java.io.IOException;
import static view.TelaInicial.pasta;
/**
 *
 * @author MeuPC
 */

public class Del {
    public static void refazerArq(String nomeArquivo) throws IOException{
        //este metodo apenas exclui o arquivo, trazando como parâmetro o nome do arquivo e o local dado na tela inicial
        File arq = new File(pasta + nomeArquivo);
        arq.delete();
        
    }
}
