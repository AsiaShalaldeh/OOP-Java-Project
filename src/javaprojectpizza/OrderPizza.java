package javaprojectpizza;

import Exceptions.IngredientsOverFlowException;
import Exceptions.InvalidEnteredValueException;
import Exceptions.OutOfStockException;
import Exceptions.PanOverFlowException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OrderPizza extends javax.swing.JFrame {

    // images will be used in GUI
    ImageIcon orderImage = new ImageIcon("order.png");
    ImageIcon logo = new ImageIcon("pizzaLogo.png");
    ImageIcon deepDishPizzaIcon = new ImageIcon("deepdishpizza.png");
    ImageIcon deepPanPizzaIcon = new ImageIcon("deeppanpizza.png");
    Set<ToppingIngredients> toppingIngredientsList = new HashSet<ToppingIngredients>();
    ArrayList<DoughIngredients> doughIngredientsList = new ArrayList();
    String style, type, size, order, name;
    double totalPrice = 0;
    int orderNo = 1;
    GetOrder getOrder = new GetOrder();
    private final LoggerInterface logger;
    private final Serialization serialization;
    private static DatabaseConnection databaseConnection;

    /**
     * Creates new form OrderPizza
     *
     * @param logger
     */
    public OrderPizza(LoggerInterface logger) {
        initComponents();
        this.logger = logger;
        serialization = new Serialization(logger);
        databaseConnection = new DatabaseConnection(logger);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doughStyle = new javax.swing.ButtonGroup();
        doughSize = new javax.swing.ButtonGroup();
        pizzaType = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        orderText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nameText = new javax.swing.JTextField();
        toppingPanel = new javax.swing.JPanel();
        mozzarella = new javax.swing.JCheckBox();
        mushroom = new javax.swing.JCheckBox();
        bellPepper = new javax.swing.JCheckBox();
        broccoli = new javax.swing.JCheckBox();
        blackOlive = new javax.swing.JCheckBox();
        onion = new javax.swing.JCheckBox();
        pizzaSauce = new javax.swing.JCheckBox();
        oregano = new javax.swing.JCheckBox();
        tomato = new javax.swing.JCheckBox();
        pizzaTypePanel = new javax.swing.JPanel();
        chicken = new javax.swing.JRadioButton();
        meat = new javax.swing.JRadioButton();
        simple = new javax.swing.JRadioButton();
        doughStylePanel = new javax.swing.JPanel();
        deepPanPizza = new javax.swing.JRadioButton();
        deepDishPizza = new javax.swing.JRadioButton();
        deepDishPizzaPic = new javax.swing.JLabel();
        deepPanPizzaPic = new javax.swing.JLabel();
        doughSizePanel = new javax.swing.JPanel();
        smallSize = new javax.swing.JRadioButton();
        mediumSize = new javax.swing.JRadioButton();
        largeSize = new javax.swing.JRadioButton();
        checkData = new javax.swing.JCheckBox();
        orderButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        tryAgainButton = new javax.swing.JButton();
        pizzaLogo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Name:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 100, 60, 25);

        orderText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderText.setText("1");
        orderText.setToolTipText("Your Order's Number");
        orderText.setEnabled(false);
        orderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderTextActionPerformed(evt);
            }
        });
        getContentPane().add(orderText);
        orderText.setBounds(180, 100, 65, 26);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Order Number:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 120, 25);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("Pizza Pizza");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(544, 13, 243, 63);

        jSeparator1.setBackground(new java.awt.Color(255, 51, 0));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 83, 1520, 16);

        nameText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameText.setToolTipText("Enter Your Name");
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        getContentPane().add(nameText);
        nameText.setBounds(365, 100, 170, 26);

        toppingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Toppings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 0))); // NOI18N
        toppingPanel.setForeground(new java.awt.Color(0, 0, 255));
        toppingPanel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mozzarella.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        mozzarella.setText("Mozzarella Cheese");

        mushroom.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        mushroom.setText("Mushroom");

        bellPepper.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        bellPepper.setText("Bell Pepper");
        bellPepper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bellPepperActionPerformed(evt);
            }
        });

        broccoli.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        broccoli.setText("Broccoli");

        blackOlive.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        blackOlive.setText("Black Olive");

        onion.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        onion.setText("Onion");

        pizzaSauce.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        pizzaSauce.setText("Pizza sauce ");

        oregano.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        oregano.setText("Oregano");

        tomato.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tomato.setText("Tomato");

        javax.swing.GroupLayout toppingPanelLayout = new javax.swing.GroupLayout(toppingPanel);
        toppingPanel.setLayout(toppingPanelLayout);
        toppingPanelLayout.setHorizontalGroup(
            toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pizzaSauce)
                    .addComponent(broccoli)
                    .addComponent(mozzarella))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toppingPanelLayout.createSequentialGroup()
                        .addComponent(oregano)
                        .addGap(78, 78, 78))
                    .addGroup(toppingPanelLayout.createSequentialGroup()
                        .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bellPepper)
                            .addComponent(mushroom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blackOlive)
                    .addComponent(onion)
                    .addComponent(tomato))
                .addGap(33, 33, 33))
        );
        toppingPanelLayout.setVerticalGroup(
            toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bellPepper)
                        .addComponent(onion))
                    .addGroup(toppingPanelLayout.createSequentialGroup()
                        .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mozzarella)
                            .addComponent(mushroom)
                            .addComponent(blackOlive))
                        .addGap(18, 18, 18)
                        .addComponent(pizzaSauce)))
                .addGap(18, 18, 18)
                .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(broccoli)
                    .addGroup(toppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(oregano)
                        .addComponent(tomato)))
                .addGap(91, 91, 91))
        );

        getContentPane().add(toppingPanel);
        toppingPanel.setBounds(24, 133, 522, 172);

        pizzaTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pizza Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        pizzaType.add(chicken);
        chicken.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        chicken.setText("Chicken Pizza");
        chicken.setToolTipText("Add Chicken To Your Pizza");

        pizzaType.add(meat);
        meat.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        meat.setText("Meat Pizza");
        meat.setToolTipText("Add Meat To Your Pizza");

        pizzaType.add(simple);
        simple.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        simple.setText("Simple");
        simple.setToolTipText("No Meat Niether Chicken");

        javax.swing.GroupLayout pizzaTypePanelLayout = new javax.swing.GroupLayout(pizzaTypePanel);
        pizzaTypePanel.setLayout(pizzaTypePanelLayout);
        pizzaTypePanelLayout.setHorizontalGroup(
            pizzaTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pizzaTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(meat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(chicken)
                .addGap(58, 58, 58)
                .addComponent(simple)
                .addGap(56, 56, 56))
        );
        pizzaTypePanelLayout.setVerticalGroup(
            pizzaTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pizzaTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pizzaTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meat)
                    .addGroup(pizzaTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chicken)
                        .addComponent(simple)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pizzaTypePanel);
        pizzaTypePanel.setBounds(24, 312, 522, 80);

        doughStylePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dough Style", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        doughStyle.add(deepPanPizza);
        deepPanPizza.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        deepPanPizza.setText("Deep-Pan Pizza");

        doughStyle.add(deepDishPizza);
        deepDishPizza.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        deepDishPizza.setText("Deep-Dish Pizza");

        javax.swing.GroupLayout doughStylePanelLayout = new javax.swing.GroupLayout(doughStylePanel);
        doughStylePanel.setLayout(doughStylePanelLayout);
        doughStylePanelLayout.setHorizontalGroup(
            doughStylePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doughStylePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doughStylePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doughStylePanelLayout.createSequentialGroup()
                        .addComponent(deepPanPizzaPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(doughStylePanelLayout.createSequentialGroup()
                        .addComponent(deepPanPizza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)))
                .addGroup(doughStylePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deepDishPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deepDishPizzaPic, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        doughStylePanelLayout.setVerticalGroup(
            doughStylePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doughStylePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doughStylePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deepPanPizza)
                    .addComponent(deepDishPizza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(doughStylePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deepDishPizzaPic, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(deepPanPizzaPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        getContentPane().add(doughStylePanel);
        doughStylePanel.setBounds(24, 486, 522, 230);

        doughSizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dough Size ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 51, 0))); // NOI18N

        doughSize.add(smallSize);
        smallSize.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        smallSize.setText("Small");
        smallSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallSizeActionPerformed(evt);
            }
        });

        doughSize.add(mediumSize);
        mediumSize.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        mediumSize.setText("Medium");

        doughSize.add(largeSize);
        largeSize.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        largeSize.setText("Large");

        javax.swing.GroupLayout doughSizePanelLayout = new javax.swing.GroupLayout(doughSizePanel);
        doughSizePanel.setLayout(doughSizePanelLayout);
        doughSizePanelLayout.setHorizontalGroup(
            doughSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doughSizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(smallSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(mediumSize)
                .addGap(92, 92, 92)
                .addComponent(largeSize)
                .addGap(66, 66, 66))
        );
        doughSizePanelLayout.setVerticalGroup(
            doughSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doughSizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doughSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smallSize)
                    .addComponent(largeSize)
                    .addComponent(mediumSize))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(doughSizePanel);
        doughSizePanel.setBounds(24, 399, 522, 80);

        checkData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkData.setText("Confirm All Data are correct");
        checkData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDataActionPerformed(evt);
            }
        });
        getContentPane().add(checkData);
        checkData.setBounds(630, 490, 260, 33);

        orderButton.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        orderButton.setForeground(new java.awt.Color(255, 51, 0));
        orderButton.setText("Order NOW");
        orderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderButton.setEnabled(false);
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(orderButton);
        orderButton.setBounds(660, 530, 180, 41);

        doneButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        doneButton.setText("Done");
        doneButton.setEnabled(false);
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        getContentPane().add(doneButton);
        doneButton.setBounds(660, 590, 180, 40);

        tryAgainButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tryAgainButton.setText("Try Again");
        tryAgainButton.setEnabled(false);
        tryAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tryAgainButtonActionPerformed(evt);
            }
        });
        getContentPane().add(tryAgainButton);
        tryAgainButton.setBounds(660, 650, 180, 40);
        getContentPane().add(pizzaLogo);
        pizzaLogo.setBounds(1285, 13, 88, 49);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jScrollPane2.setViewportView(orderTextArea);

        orderTextArea.setColumns(20);
        orderTextArea.setRows(5);
        jScrollPane1.setViewportView(orderTextArea);

        jScrollPane2.setViewportView(jScrollPane1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(570, 130, 370, 340);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pizzaman.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(950, 80, 400, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderTextActionPerformed

    // Method to enable all options again after finishing the previous order
    public void enableAllOptions() {
        toppingPanel.setEnabled(true);
        pizzaTypePanel.setEnabled(true);
        doughStylePanel.setEnabled(true);
        doughSizePanel.setEnabled(true);
        nameText.setEnabled(true);
        mozzarella.setEnabled(true);
        mushroom.setEnabled(true);
        blackOlive.setEnabled(true);
        pizzaSauce.setEnabled(true);
        broccoli.setEnabled(true);
        bellPepper.setEnabled(true);
        onion.setEnabled(true);
        tomato.setEnabled(true);
        oregano.setEnabled(true);
        simple.setEnabled(true);
        chicken.setEnabled(true);
        meat.setEnabled(true);
        deepPanPizza.setEnabled(true);
        deepDishPizza.setEnabled(true);
        smallSize.setEnabled(true);
        mediumSize.setEnabled(true);
        largeSize.setEnabled(true);
        checkData.setEnabled(true);
    }

    // Method to disable all options after confirmation 
    public void disableAllOptions() {
        toppingPanel.setEnabled(false);
        pizzaTypePanel.setEnabled(false);
        doughStylePanel.setEnabled(false);
        doughSizePanel.setEnabled(false);
        nameText.setEnabled(false);
        mozzarella.setEnabled(false);
        mushroom.setEnabled(false);
        blackOlive.setEnabled(false);
        pizzaSauce.setEnabled(false);
        broccoli.setEnabled(false);
        bellPepper.setEnabled(false);
        onion.setEnabled(false);
        tomato.setEnabled(false);
        oregano.setEnabled(false);
        simple.setEnabled(false);
        chicken.setEnabled(false);
        meat.setEnabled(false);
        deepPanPizza.setEnabled(false);
        deepDishPizza.setEnabled(false);
        smallSize.setEnabled(false);
        mediumSize.setEnabled(false);
        largeSize.setEnabled(false);
        checkData.setEnabled(false);

    }

    /* Method to disable all options and reset all values to be ready for 
       new customer
     */
    private void clearAllOptions() {
        doneButton.setEnabled(false);
        nameText.setText("");
        mozzarella.setSelected(false);
        mushroom.setSelected(false);
        bellPepper.setSelected(false);
        broccoli.setSelected(false);
        blackOlive.setSelected(false);
        onion.setSelected(false);
        pizzaSauce.setSelected(false);
        oregano.setSelected(false);
        tomato.setSelected(false);
        checkData.setSelected(false);
        doughStyle.clearSelection();
        doughSize.clearSelection();
        pizzaType.clearSelection();
        style = type = size = order = name = "";
        totalPrice = 0;
        toppingIngredientsList.clear();
        doughIngredientsList.clear();
        orderButton.setEnabled(false);
        tryAgainButton.setEnabled(false);
    }

    public void setDoughIngredients() {
        // prepare all dough ingredients 
        // Name
        // only flour has calories
        try {
            // Water
            DoughIngredients water = new DoughIngredients("Water");
            double waterTotalWeight = DoughIngredients.getWaterTotalWeight();
            water.setWeight(320, waterTotalWeight, size); // default weight for large size
            // decrease total weight of the water each time we make a new dough
            DoughIngredients.setWaterTotalWeight(waterTotalWeight - water.getWeight());
            water.setIngredientCalories(0);
            doughIngredientsList.add(water);
            // Flour
            DoughIngredients flour = new DoughIngredients("Flour");
            double flourTotalWeight = DoughIngredients.getFlourTotalWeight();
            flour.setWeight(500, flourTotalWeight, size);
            DoughIngredients.setFlourTotalWeight(flourTotalWeight - flour.getWeight());
            flour.setIngredientCalories(4 * flour.getWeight());
            doughIngredientsList.add(flour);
            // Yeast
            DoughIngredients yeast = new DoughIngredients("Yeast");
            double yeastTotalWeight = DoughIngredients.getYeastTotalWeight();
            yeast.setWeight(7, flourTotalWeight, size);
            DoughIngredients.setYeastTotalWeight(yeastTotalWeight - yeast.getWeight());
            yeast.setIngredientCalories(0);
            doughIngredientsList.add(yeast);
            // Olive Oil
            DoughIngredients oliveOil = new DoughIngredients("Olive Oil");
            double oliveOilTotalWeight = DoughIngredients.getOliveOilTotalWeight();
            oliveOil.setWeight(75, oliveOilTotalWeight, size);
            DoughIngredients.setOliveOilTotalWeight(oliveOilTotalWeight - oliveOil.getWeight());
            oliveOil.setIngredientCalories(0);
            doughIngredientsList.add(oliveOil);
            // Suger
            DoughIngredients suger = new DoughIngredients("Suger");
            double sugerTotalWeight = DoughIngredients.getSugerTotalWeight();
            suger.setWeight(75, sugerTotalWeight, size);
            DoughIngredients.setSugerTotalWeight(sugerTotalWeight - suger.getWeight());
            suger.setIngredientCalories(0);
            doughIngredientsList.add(suger);
            // Salt
            DoughIngredients salt = new DoughIngredients("Salt");
            double saltTotalWeight = DoughIngredients.getSaltTotalWeight();
            suger.setWeight(75, saltTotalWeight, size);
            DoughIngredients.setSaltTotalWeight(saltTotalWeight - salt.getWeight());
            salt.setIngredientCalories(0);
            doughIngredientsList.add(salt);
        } catch (OutOfStockException ex) {
            // Exception if one of ingredients sold out
            JOptionPane.showMessageDialog(null, ex.getMessage());
            logger.log(ex.getMessage());
            System.exit(0); // Exit the program (Machine)
        }
    }

    public void setAllData() {
        name = nameText.getText();
        // boolean variables to be sure that customer entered all information or not 
        boolean isSizeSelected = smallSize.isSelected() || mediumSize.isSelected() || largeSize.isSelected();
        boolean isStyleSelected = deepPanPizza.isSelected() || deepDishPizza.isSelected();
        boolean isTypeSelected = chicken.isSelected() || meat.isSelected() || simple.isSelected();
        boolean isToppingSelected = mozzarella.isSelected() || mushroom.isSelected() || blackOlive.isSelected()
                || pizzaSauce.isSelected() || bellPepper.isSelected() || onion.isSelected()
                || broccoli.isSelected() || oregano.isSelected() || tomato.isSelected();

        // get size from customer and store it into size variable
        if (smallSize.isSelected()) {
            size = "small";
            isSizeSelected = true;
        } else if (mediumSize.isSelected()) {
            size = "medium";
            isSizeSelected = true;
        } else if (largeSize.isSelected()) {
            size = "large";
            isSizeSelected = true;
        }
        // get sstyle from customer and store it into sstyle variable
        if (deepPanPizza.isSelected()) {
            style = "Deep-Pan";
            isStyleSelected = true;
        } else if (deepDishPizza.isSelected()) {
            style = "Deep-Dish";
            isStyleSelected = true;
        }

        try {
            if (isSizeSelected) {
                // name , isFresh 
                // set default weight for large size 
                // decrease total weight of the topping each time we make a new object 
                // set topping price = gram price * total weight
                // set topping calories = gram calories * total weight
                if (mozzarella.isSelected()) {
                    ToppingIngredients mozzarella = new ToppingIngredients("Mozzarella Cheese", true);
                    double totalWeight = ToppingIngredients.getMozzarellaTotalWeight();
                    mozzarella.setWeight(200, totalWeight, size);
                    ToppingIngredients.setMozzarellaTotalWeight(totalWeight - mozzarella.getWeight());
                    mozzarella.setPrice(0.025 * mozzarella.getWeight());
                    mozzarella.setIngredientCalories(3 * mozzarella.getWeight());
                    toppingIngredientsList.add(mozzarella);
                }
                if (mushroom.isSelected()) {
                    ToppingIngredients mushroom = new ToppingIngredients("Mushroom", false);
                    double totalWeight = ToppingIngredients.getMushroomTotalWeight();
                    mushroom.setWeight(88, totalWeight, size);
                    ToppingIngredients.setMushroomTotalWeight(totalWeight - mushroom.getWeight());
                    mushroom.setPrice(0.5 * mushroom.getWeight());
                    mushroom.setIngredientCalories(0.48 * mushroom.getWeight());
                    toppingIngredientsList.add(mushroom);
                }
                if (bellPepper.isSelected()) {
                    ToppingIngredients bellPepper = new ToppingIngredients("Bell Pepper", false);
                    double totalWeight = ToppingIngredients.getBellPepperTotalWeight();
                    bellPepper.setWeight(150, totalWeight, size);
                    ToppingIngredients.setBellPepperTotalWeight(totalWeight - bellPepper.getWeight());
                    bellPepper.setPrice(0.00765 * bellPepper.getWeight());
                    bellPepper.setIngredientCalories(0.38 * bellPepper.getWeight());
                    toppingIngredientsList.add(bellPepper);

                }
                if (broccoli.isSelected()) {
                    ToppingIngredients broccoli = new ToppingIngredients("Broccoli", false);
                    double totalWeight = ToppingIngredients.getBroccoliTotalWeight();
                    broccoli.setWeight(90, totalWeight, size);
                    ToppingIngredients.setBroccoliTotalWeight(totalWeight - broccoli.getWeight());
                    broccoli.setPrice(0.013 * broccoli.getWeight());
                    broccoli.setIngredientCalories(0.35 * broccoli.getWeight());

                    toppingIngredientsList.add(broccoli);

                }
                if (blackOlive.isSelected()) {
                    ToppingIngredients blackOlive = new ToppingIngredients("Black Olive", true);
                    double totalWeight = ToppingIngredients.getBlackOliveTotalWeight();
                    blackOlive.setWeight(50, totalWeight, size);
                    ToppingIngredients.setBlackOliveTotalWeight(totalWeight - blackOlive.getWeight());
                    blackOlive.setPrice(0.05 * blackOlive.getWeight());
                    blackOlive.setIngredientCalories(1.05 * blackOlive.getWeight());

                    toppingIngredientsList.add(blackOlive);

                }
                if (onion.isSelected()) {
                    ToppingIngredients onion = new ToppingIngredients("Onion", false);
                    double totalWeight = ToppingIngredients.getOnionTotalWeight();
                    onion.setWeight(55, totalWeight, size);
                    ToppingIngredients.setOnionTotalWeight(totalWeight - onion.getWeight());
                    onion.setPrice(0.0183 * onion.getWeight());
                    onion.setIngredientCalories(0.58 * onion.getWeight());
                    toppingIngredientsList.add(onion);

                }
                if (pizzaSauce.isSelected()) {
                    ToppingIngredients pizzaSauce = new ToppingIngredients("Pizza Sauce", false);
                    double totalWeight = ToppingIngredients.getPizzaSauceTotalWeight();
                    pizzaSauce.setWeight(88, totalWeight, size);
                    ToppingIngredients.setPizzaSauceTotalWeight(totalWeight - pizzaSauce.getWeight());
                    pizzaSauce.setPrice(0.0038 * pizzaSauce.getWeight());
                    pizzaSauce.setIngredientCalories(0.53 * pizzaSauce.getWeight());
                    toppingIngredientsList.add(pizzaSauce);

                }
                if (oregano.isSelected()) {
                    ToppingIngredients oregano = new ToppingIngredients("Oregano", true);
                    double totalWeight = ToppingIngredients.getOreganoTotalWeight();
                    oregano.setWeight(150, totalWeight, size);
                    ToppingIngredients.setOreganoTotalWeight(totalWeight - oregano.getWeight());
                    oregano.setPrice(0.0031 * oregano.getWeight());
                    oregano.setIngredientCalories(2.7 * oregano.getWeight());
                    toppingIngredientsList.add(oregano);

                }
                if (tomato.isSelected()) {
                    ToppingIngredients tomato = new ToppingIngredients("Tomato", false);
                    double totalWeight = ToppingIngredients.getTomatoTotalWeight();
                    tomato.setWeight(160, totalWeight, size);
                    ToppingIngredients.setTomatoTotalWeight(totalWeight - tomato.getWeight());
                    tomato.setPrice(0.0041 * tomato.getWeight());
                    tomato.setIngredientCalories(0.18 * tomato.getWeight());

                    toppingIngredientsList.add(tomato);

                }

                // get type of pizza and store it in type variable 
                // name , doughSize , isFresh 
                if (chicken.isSelected()) {
                    type = "Chicken Pizza ";
                    isTypeSelected = true;
                    ToppingIngredients chickenBreast = new ToppingIngredients("Chicken Breast", false);
                    double totalWeight = ToppingIngredients.getChickenBreastTotalWeight();
                    chickenBreast.setWeight(100, totalWeight, size);
                    ToppingIngredients.setChickenBreastTotalWeight(totalWeight - chickenBreast.getWeight());
                    chickenBreast.setPrice(0.044 * chickenBreast.getWeight());
                    chickenBreast.setIngredientCalories(2 * chickenBreast.getWeight());
                    toppingIngredientsList.add(chickenBreast);
                } else if (meat.isSelected()) {
                    type = "Meat Pizza";
                    isTypeSelected = true;
                    ToppingIngredients meat = new ToppingIngredients("Meat", false);
                    double totalWeight = ToppingIngredients.getMeatTotalWeight();
                    meat.setWeight(50, totalWeight, size);
                    ToppingIngredients.setMeatTotalWeight(totalWeight - meat.getWeight());
                    meat.setPrice(0.01 * meat.getWeight());
                    meat.setIngredientCalories(3 * meat.getWeight());

                    toppingIngredientsList.add(meat);
                } else if (simple.isSelected()) {
                    type = "Simple";
                    isTypeSelected = true;
                }
            } else {
                isSizeSelected = false;
            }
            // if customer choose all options 
            if (isTypeSelected && isSizeSelected && isStyleSelected && name.equals("") == false && isToppingSelected) //&& toppings
            {
                orderButton.setEnabled(true);
                disableAllOptions();
            } else {
                JOptionPane.showMessageDialog(null, "Make sure that you entered all Information !!");
            }
        } catch (OutOfStockException ex) {
            // Exception if one of topping ingredients sold out
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }

    }

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void bellPepperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bellPepperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bellPepperActionPerformed

    private void smallSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smallSizeActionPerformed

    private void checkDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDataActionPerformed
        // Confirm Check Box
        // make sure that all variables are clear
        style = type = size = order = name = "";
        totalPrice = 0;
        toppingIngredientsList.clear();
        doughIngredientsList.clear();
        // prepare objects of topping and other variables 
        setAllData();
    }//GEN-LAST:event_checkDataActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        // Order Button
        // Prepare A Dough 
        setDoughIngredients();
        Mixer mixer = new Mixer(126, 80); // speed = 126 RPM , bowlSize = 80 quart
        serialization.writeObjectToFile(mixer); // write object to a file
        // make object of dough
        Dough dough = mixer.mixDough(size, style, doughIngredientsList);
        dough.setDoughIngredientsList(doughIngredientsList);
        dough.setPrice();
        logger.log("The Dough Has Been Mixed");
        serialization.writeObjectToFile(dough); // write object to a file
        // calculate total price = toppings price + dough price
        for (ToppingIngredients topping : toppingIngredientsList) {
            totalPrice += topping.getPrice();
        }
        totalPrice += dough.getPrice();
        // Format of price and calories
        DecimalFormat df = new DecimalFormat("0.00");
        // Show Order into Text Area
        order = "Welcome " + name;
        order += ",\nOrder No = " + orderText.getText() + "\nYou Ordered  ";
        order += size + ", " + style + " and \n" + type + " Pizza with Toppings: \n";
        for (ToppingIngredients topping : toppingIngredientsList) {
            order += topping.getName() + "\n";
        }
        order += "Total Price: " + df.format(totalPrice) + " $ \n";
        orderTextArea.setText(order);
        boolean isDone = false;
        try {
            Pan pan = new Pan(size, dough, toppingIngredientsList);
            pan.pourDough();
            JOptionPane.showMessageDialog(null, "Wait Until Your Order Get Ready...");
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            logger.log("Dough Is Poured");
            pan.addToppingIngredients();
            logger.log("Toppings Are Added");
            serialization.writeObjectToFile(pan);

            // put pizza pan into oven
            Oven oven = new Oven(450, pan); // temperature
            serialization.writeObjectToFile(oven);

            // create pizza object
            Pizza pizza = oven.bakePizza(dough, toppingIngredientsList, totalPrice, type);
            logger.log("Pizza Is Baked");
            serialization.writeObjectToFile(pizza);
            order += "Total Calories = " + df.format(pan.getTotalCalories());
            orderTextArea.setText(order); // add total calories to text area (your order)

            boolean cutDone = false;
            while (!cutDone) {
                try {
                    String numberOfSlices = JOptionPane.showInputDialog("Enter Number Of Slices :"
                            + "2 / 4 / 6 / 8 / 10 :");
                    if (numberOfSlices == null) {
                        throw new NullPointerException("You Have To Enter A Value Before Exit");
                    }
                    orderTextArea.setText(order + "\nCalories for each slice = " + df.format(pan.cutPizza(numberOfSlices)));
                    cutDone = true;
                } catch (InvalidEnteredValueException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input !!", JOptionPane.ERROR_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " You Have To Enter "
                            + "A Numeric Value. Try Again", "Invalid Input !!", JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Be Careful !!", JOptionPane.ERROR_MESSAGE);
                    // if customer didn't enter any value
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrderPizza.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            // show Order to the customer (box)
            getOrder.setVisible(true);
            orderButton.setEnabled(false);
            isDone = true;
            logger.log("Order " + (orderNo++) + " Is Ready");
            System.out.println("Your Order Is Ready ");

            JOptionPane.showMessageDialog(null, "Hope You Enjoy What We Have Made For You");
            // Connect to DataBase
            databaseConnection.writeToDB(name, type, size, style, totalPrice);
            System.out.println("======================");
            doneButton.setEnabled(true);
            tryAgainButton.setEnabled(false);
        } catch (PanOverFlowException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("===============================");

        } catch (IngredientsOverFlowException ex) {
            // No more space for toppings 
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
            System.out.println("===============================");

        }
        if (!isDone) {
            // if there is an Exception, customer should Try Again
            orderTextArea.setText("");
            doneButton.setEnabled(false);
            orderButton.setEnabled(false);
            tryAgainButton.setEnabled(true);
        }
    }//GEN-LAST:event_orderButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // Done Button
        // Increase Order Number by one
        orderNo = Integer.parseInt(orderText.getText()) + 1;
        orderText.setText(orderNo + "");
        orderTextArea.setText("");
        // be ready for new Order
        clearAllOptions();
        enableAllOptions();
        // Remove previous order
        getOrder.setVisible(false);
    }//GEN-LAST:event_doneButtonActionPerformed

    private void tryAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tryAgainButtonActionPerformed
        // Try Again Button
        // Give customer another chance to order
        clearAllOptions();
        enableAllOptions();
    }//GEN-LAST:event_tryAgainButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // when Window opened, all images should appear
        pizzaLogo.setIcon(logo);
        deepDishPizzaPic.setIcon(deepDishPizzaIcon);
        deepPanPizzaPic.setIcon(deepPanPizzaIcon);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PizzaLogger logger = new PizzaLogger();
                new OrderPizza(logger).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bellPepper;
    private javax.swing.JCheckBox blackOlive;
    private javax.swing.JCheckBox broccoli;
    private javax.swing.JCheckBox checkData;
    private javax.swing.JRadioButton chicken;
    private javax.swing.JRadioButton deepDishPizza;
    private javax.swing.JLabel deepDishPizzaPic;
    private javax.swing.JRadioButton deepPanPizza;
    private javax.swing.JLabel deepPanPizzaPic;
    private javax.swing.JButton doneButton;
    private javax.swing.ButtonGroup doughSize;
    private javax.swing.JPanel doughSizePanel;
    private javax.swing.ButtonGroup doughStyle;
    private javax.swing.JPanel doughStylePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton largeSize;
    private javax.swing.JRadioButton meat;
    private javax.swing.JRadioButton mediumSize;
    private javax.swing.JCheckBox mozzarella;
    private javax.swing.JCheckBox mushroom;
    private javax.swing.JTextField nameText;
    private javax.swing.JCheckBox onion;
    private javax.swing.JButton orderButton;
    private javax.swing.JTextField orderText;
    private javax.swing.JTextArea orderTextArea;
    private javax.swing.JCheckBox oregano;
    private javax.swing.JLabel pizzaLogo;
    private javax.swing.JCheckBox pizzaSauce;
    private javax.swing.ButtonGroup pizzaType;
    private javax.swing.JPanel pizzaTypePanel;
    private javax.swing.JRadioButton simple;
    private javax.swing.JRadioButton smallSize;
    private javax.swing.JCheckBox tomato;
    private javax.swing.JPanel toppingPanel;
    private javax.swing.JButton tryAgainButton;
    // End of variables declaration//GEN-END:variables
}
