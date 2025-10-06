// Importa bibliotecas necessárias
import javax.swing.*; 
import java.awt.*;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exemplojoptionpane extends JFrame { // Classe principal
    
    // Declaração dos botões
    private JButton mensagem;
    private JButton fechar;

    // Construtor da classe
    public Exemplojoptionpane() {
        super("Teste do Componente OptionPane");
        
        // Cria os botões
        mensagem = new JButton("Mensagem");
        fechar = new JButton("Fechar");

        Container pane = this.getContentPane();
        
        pane.add(mensagem);
        pane.add(fechar);

        pane.setLayout(null);

        // Define tamanho dos botões
        mensagem.setBounds(20, 30, 150, 35);
        fechar.setBounds(20, 90, 150, 35);

        // Associa ação ao botão "Mensagem"
        mensagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent b) {
                buttonMensagemActionPerformed(b); // Chama método auxiliar
            }
        });

        // Associa ação ao botão "Fechar"
        fechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent b) {
                buttonConfirmActionPerformed(b); // Chama método auxiliar
            }
        });

        // Configurações da janela
        this.setSize(400, 310);
        this.setContentPane(pane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Método que trata a ação do botão "Mensagem"
    private void buttonMensagemActionPerformed(ActionEvent b) {
        String nome = JOptionPane.showInputDialog(
            this,
            "Qual é o seu nome?", // Pergunta
            "Entrada de Dados", // Título da caixa
            JOptionPane.QUESTION_MESSAGE
        );
        
        // Verificação de mensagem valida
        if (nome != null && !nome.trim().isEmpty()) {
            // Mensagem de boas vindas
            JOptionPane.showMessageDialog(
                this,
                "Olá, " + nome + "!",
                "Bem-vindo",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            // Caso não digite nada ou cancele
            JOptionPane.showMessageDialog(
                this,
                "Você não digitou um nome.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    // Método que trata a ação do botão "Fechar"
    private void buttonConfirmActionPerformed(ActionEvent b) {
        int retorno = JOptionPane.showConfirmDialog(
            this,
            "Deseja fechar?",
            "Fechar",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Se o usuário escolheu "Sim", fecha o programa
        if (retorno == JOptionPane.YES_OPTION) {
            System.exit(0); // Fecha o sistema
        }
    }

    // Ponto de entrada do programa
    public static void main(String[] args) {
        new Exemplojoptionpane();
    }
}
