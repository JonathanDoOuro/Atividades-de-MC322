	package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      char board[][] = {
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
            
      Tabuleiro tabu = new Tabuleiro(board);
      
      tk.writeBoard("Tabuleiro inicial", tabu.mostra());
      for (int i = 0; i < commands.length; i++) {
    	  tabu.movimento(commands[i]);
    	  tk.writeBoard("source: " + commands[i].substring(0, 2) + ";" + " target: " + commands[i].substring(3, 5) , tabu.mostra());
      }
    	  

      tk.stop();
   }

}
