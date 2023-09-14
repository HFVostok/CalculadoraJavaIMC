import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraMMCGridBagLayout {
    private JFrame frame;
    private JTextField inputField1;
    private JTextField inputField2;
    private JButton calculateButton; // Botão para calcular o MMC
    private JLabel resultLabel; // Rótulo para exibir o resultado

    // Método construtor da classe
    public CalculadoraMMCGridBagLayout() {
        // Configurando a janela da aplicação
        frame = new JFrame("Calculadora IMC"); // Título da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar a janela encerra o programa
        frame.setLayout(new GridBagLayout()); // Configurando o layout da janela como GridBagLayout

        // Configurando restrições para componentes no layout GridBag
        GridBagConstraints ppcimc = new GridBagConstraints();
        ppcimc.gridx = 0;
        ppcimc.gridy = 0;
        ppcimc.fill = GridBagConstraints.HORIZONTAL;
        ppcimc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno dos componentes

        // Adicionando rótulos "Peso (kg)" e "Altura (m)" na janela
        frame.add(new JLabel("Peso (kg): "), ppcimc);
        ppcimc.gridy++;
        frame.add(new JLabel("Altura (m): "), ppcimc);

        // Configurando campos de entrada para números
        ppcimc.gridx = 1;
        ppcimc.gridy = 0;
        ppcimc.weightx = 1.0; // Largura proporcional
        ppcimc.fill = GridBagConstraints.HORIZONTAL;
        inputField1 = new JTextField();
        frame.add(inputField1, ppcimc);
        ppcimc.gridy++;
        inputField2 = new JTextField();
        frame.add(inputField2, ppcimc);

        // Configurando o botão "Calcular IMC"
        ppcimc.gridx = 0;
        ppcimc.gridy++;
        ppcimc.gridwidth = 2; // Ocupa duas colunas
        calculateButton = new JButton("Calcular IMC"); // Texto no botão
        frame.add(calculateButton, ppcimc);

        // Configurando o rótulo para exibir o resultado
        ppcimc.gridy++;
        ppcimc.gridwidth = 2;
        resultLabel = new JLabel();
        frame.add(resultLabel, ppcimc);

        // Adicionando um ouvinte de ação ao botão
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMMC(); // Quando o botão é clicado, chama a função calcularMMC
            }
        });

        frame.pack(); // Ajusta o tamanho da janela automaticamente
        frame.setVisible(true); // Torna a janela visível
    }

    // Função para calcular o MMC
    private void calcularMMC() {
        try {
            // Lê os valores dos campos de entrada como números de ponto flutuante
            float numero1 = Float.parseFloat(inputField1.getText());
            float numero2 = Float.parseFloat(inputField2.getText());
            float mmc = calcularMMC(numero1, numero2); // Chama a função para calcular o MMC

            // Exibe o resultado na forma de texto no rótulo
            resultLabel.setText("O peso: " + numero1 + " e Altura: " + numero2 + " é: " + mmc);
        } catch (NumberFormatException e) {
            // Em caso de entrada inválida, exibe uma mensagem de erro no rótulo
            resultLabel.setText("Digite números válidos.");
        }
    }

    // Função para calcular o MMC
    private float calcularMMC(float numero1, float numero2) {
        float mmc = numero1 / (numero2 * numero2); // Cálculo inicial

        // Enquanto o resultado não for divisível pelo primeiro número, adiciona o
        // primeiro número
        while (mmc % numero1 != 0) {
            mmc += numero1;
        }

        return mmc; // Retorna o resultado do MMC
    }
}