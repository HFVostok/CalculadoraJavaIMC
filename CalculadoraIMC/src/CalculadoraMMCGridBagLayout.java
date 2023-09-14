import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraMMCGridBagLayout {
    private JFrame frame;
    private JTextField inputField1;
    private JTextField inputField2;
    private JButton calculateButton;
    private JLabel resultLabel;

    public CalculadoraMMCGridBagLayout() {
        frame = new JFrame("Calculadora IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        frame.add(new JLabel("Peso (kg): "), gbc);
        gbc.gridy++;
        frame.add(new JLabel("Altura (m): "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputField1 = new JTextField();
        frame.add(inputField1, gbc);
        gbc.gridy++;
        inputField2 = new JTextField();
        frame.add(inputField2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        calculateButton = new JButton("Calcular IMC");
        frame.add(calculateButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        resultLabel = new JLabel();
        frame.add(resultLabel, gbc);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMMC();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void calcularMMC() {
        try {

            float numero1 = Float.parseFloat(inputField1.getText());
            float numero2 = Float.parseFloat(inputField2.getText());
            float imc = calcularMMC(numero1, numero2);

            resultLabel.setText("O peso: " + numero1 + " e Altura: " + numero2 + " é: " + imc);
        } catch (NumberFormatException e) {
            resultLabel.setText("Digite números válidos.");
        }
    }

    private float calcularMMC(float numero1, float numero2) {

        float imc = numero1 / (numero2 * numero2);

        while (imc % numero1 != 0) {
            imc += numero1;
        }

        return imc;
    }

}
