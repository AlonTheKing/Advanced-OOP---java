package graphics;//package graphics;

import Animals.*;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*
this class represent the race
 */
public class CompetitionFrame extends JFrame implements ActionListener {

    private final JTable table;
    private DrawingComponent[] myImages;
    private int imgSize = 0;
    private final ZooPanel myZoo;
    //                                                       [0]                                                [1]                              [2]                  [3]                                [4]                                [5]                             [6]                                [7]               [8]
    private final String[][] names = {{"Terrestrial Animal", "Air Animal", "Water Animal"}, {"dog1", "dog2", "dog3", "dog4", "dog5", "dog6"}, {"cat1", "cat2"}, {"snake1", "snake2", "snake3"}, {"alligator1", "alligator2", "alligator3"}, {"whale1", "whale2"}, {"dolphin1", "dolphin2", "dolphin3"}, {"eagle1", "eagle2", "eagle3"}, {"pigeon1"}};
    private final Container pane;
    private String selectedType;
    private String selectedSkin;
    private final DefaultTableModel model;
    private final JScrollPane tablepPane;

    private final java.util.Timer[] t = new Timer[5];

    private String animalType1;
    private Animal[] myAnimal;
    private int animalSize = 0;
    private int medalSize = 0;
    protected Gender myGender;
    protected Double weight;
    protected Double speed;
    protected Medal[] medal;
    protected Point position;
    protected boolean castrated;
    protected Snake.Poisonous poison;
    protected String isPoison;


    /*
    CompetitionFrame default Constructor
    here we're setting up the backgroud, relevant panels and menu bars + initializing stuffs for certain operations.
     */
    public CompetitionFrame() throws IOException {

        setSize(1118, 950);
        setTitle("Competition");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        pane = this.getContentPane();

        ZooMenuPanel myMenu = new ZooMenuPanel(this);
        myZoo = new ZooPanel(this);


        String backgroundImage = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\competitionBackground.png";
        AddImg(backgroundImage, false, null);
        myImages[0].setLayout(null);
        pane.add(myImages[0], BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(20);
        model = new DefaultTableModel();
        String[] columns = {"Animal", "Category", "Type", "Speed", "Energy Amount", "Distance", "Energy consumption"};
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        tablepPane = new JScrollPane(table);


        setVisible(true);

    }

    /*
    action listener that works for the buttons, each button leads to unique funtionality.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String keyWord = e.getActionCommand();

        switch (keyWord) {
            case "Exit" -> {
                System.exit(0);
            }
            case "Help" -> {
                JOptionPane.showMessageDialog(this, "Home Work 2 \nGUI");
            }
            case "Competition" -> {
                createCompetition();
            }
            case "Add Animal" -> {

                AddAnimal();
            }
            case "Clear" -> {
                ClearAnimal();
            }
            case "Eat" -> {
                try {
                    Eat();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            case "Info" -> {
                CreateInfo();
            }

        }

    }

    /*
    AddCopetitior is a method that in charge of the field "myAnimal" -> each time the user choose to create a new animal,
    this method is adding this animal to an array of animal, so i can use it later on.
     */
    private void AddCompetitor(Animal animal) {

        model.addRow(new Object[]{animal.getName(), animal.getType(), animalType1, animal.getSpeed(), animal.getCurrEnergy(), animal.getTotalDistance(), animal.GetAddedEnergy()});

        System.out.println(animal.toString());
        Animal[] temp;
        if (this.animalSize > 0) {
            temp = new Animal[this.myAnimal.length];
            for (int i = 0; i < this.myAnimal.length; ++i) {
                temp[i] = this.myAnimal[i];
            }
            this.animalSize += 1;
            this.myAnimal = new Animal[this.animalSize];
            for (int i = 0; i < temp.length; ++i) {
                this.myAnimal[i] = temp[i];
            }
            this.myAnimal[this.animalSize - 1] = animal;

        } else {
            this.myAnimal = new Animal[1];
            myAnimal[0] = animal;
            this.animalSize += 1;
        }


    }

    /*
    Eat() method can open a new JDialog window, and in this window, the user can input the amount of energy he whats to give
    to his animal.
    +
    if the animal is already displayed on the screen and stopped, we need to feed it so it continue to move.
     */
    private void Eat() throws Exception {

        if (this.imgSize > 1) {
            JDialog myDialog = new JDialog(this, "Feed The Animal");
            int feed;
            myDialog.setVisible(true);
            //myDialog.setResizable(true);
            myDialog.setSize(150, 150);
            //myDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
            myDialog.setLayout(null);
            JLabel label = new JLabel("feed me:");
            label.setBounds(15, 10, 100, 40);
            myDialog.add(label);


            JTextField f1 = new JTextField();
            f1.setBounds(80, 20, 50, 20);
            myDialog.add(f1);
            DrawingComponent bg = new DrawingComponent(myImages[1].getMyPath(), true);
            myDialog.add(bg);
            bg.setBounds(15, 5, myDialog.getWidth(), myDialog.getHeight());
            myDialog.validate();
            myDialog.repaint();

            f1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        myAnimal[animalSize - 1].AddEnergy(Integer.parseInt(f1.getText()));
                        myDialog.dispose();
                    } catch (Exception ex) {
                        System.out.println("wrong input");
                    }

                }
            });
        } else {
            throw new Exception("there is no animal to feed.");
        }

    }

    /*
    CreateInfo() method is a method that dynamically updated a Jtable each time the animal move.
     */
    private void CreateInfo() {
        JDialog infoDialog = new JDialog(this, "Competitors Information Dialog");
        infoDialog.setLayout(null);
        if (this.animalSize > 0) {
            tablepPane.setLocation(0, 0);
            tablepPane.setBounds(0, 0, 700, 300);
            infoDialog.add(tablepPane);
            infoDialog.setResizable(true);
            table.getColumnModel().getColumn(0).setPreferredWidth(36);
            infoDialog.setSize(tablepPane.getWidth() + 5, tablepPane.getHeight());

            infoDialog.setVisible(true);

        } else {
            System.out.println("no information available");
        }
    }

    /*
    createCompetition() is a method that allow the user to choose which kind of "Competition" he wants, "air, water etc.. "
     */
    private void createCompetition() {

        final String[] names = {"Terrestrial Animal", "Air Animal", "Water Animal"};
        JComboBox<String> myCombo = new JComboBox<>(names);
        JLabel label;


        JDialog myDialog = new JDialog(this, "Add Competition Dialog");

        myDialog.setVisible(true);
        myDialog.setResizable(true);
        myDialog.setSize(400, 150);
        //myDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myDialog.setLayout(null);

        label = new JLabel("Please choose your competition:");
        label.setBounds(15, 5, 300, 40);
        myDialog.add(label);

        myCombo.setBounds(220, 13, 150, 25);


        // combo action listener
        myCombo.addActionListener(e -> {
            String key = (String) myCombo.getSelectedItem();
            switch (Objects.requireNonNull(key)) {
                case "Terrestrial Animal" -> {
                    selectedType = (String) myCombo.getSelectedItem();
                    myDialog.dispose();
                }
                case "Water Animal" -> {
                    selectedType = (String) myCombo.getSelectedItem();
                    myDialog.dispose();
                }
                case "Air Animal" -> {
                    selectedType = (String) myCombo.getSelectedItem();
                    myDialog.dispose();
                }
            }
        });

        myZoo.getAddAnimal().setEnabled(true);
        myDialog.add(myCombo);
    }

    /*
    AddAnimal() is a method that create an instance of the required animal, by filling certain details about a specific animal
    in short about how it does it:
    1. identify the animalType
    2. identify the animalSkin
    3. dynamically display the relevant fields
     */
    private void AddAnimal() {

        JDialog AddAnimalDialog = new JDialog(this, "Add Animal Dialog");

        AddAnimalDialog.setResizable(false);
        AddAnimalDialog.setSize(365, 330);
        AddAnimalDialog.setLayout(null);

        // NEED TO CHECK IF THE ANIMAL IS FIT TO THE COMPETITION TYPE - SHOULD BE AN EXCPETION
        JLabel animalCat = new JLabel("Choose Animal Category:");
        animalCat.setBounds(15, 7, 150, 20);
        AddAnimalDialog.add(animalCat);


        JLabel animalType = new JLabel("Choose Animal: ");
        animalType.setBounds(15, 37, 150, 20);
        AddAnimalDialog.add(animalType);

        JLabel animalDesign = new JLabel("Choose Animal Design: ");
        animalDesign.setBounds(15, 67, 150, 20);
        AddAnimalDialog.add(animalDesign);

        JLabel ilustration = new JLabel("Illustration: ");
        ilustration.setBounds(15, 97, 150, 20);
        AddAnimalDialog.add(ilustration);


        JComboBox<String> designCombo = new JComboBox<>();
        designCombo.setBounds(180, 70, 150, 20);
        designCombo.setEnabled(false);
        AddAnimalDialog.add(designCombo);


        JComboBox<String> myUpdatedCombo = new JComboBox<>();
        myUpdatedCombo.setBounds(180, 40, 150, 20);
        myUpdatedCombo.setEnabled(false);
        AddAnimalDialog.add(myUpdatedCombo);

        JComboBox<String> myCombo = new JComboBox<>(names[0]);
        myCombo.setBounds(180, 10, 150, 20);
        AddAnimalDialog.add(myCombo);


        myCombo.addActionListener(e -> {
            myUpdatedCombo.removeAllItems();

            if (!selectedType.equals(Objects.requireNonNull(myCombo.getSelectedItem()))) {
                try {
                    JOptionPane.showMessageDialog(AddAnimalDialog, "Cannot continue:\n Bad match up.");
                    throw new Exception("bad fit");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            } else if (selectedType.equals(Objects.requireNonNull(myCombo.getSelectedItem()))) {
                //CreateAnimal newAnimal= new CreateAnimal();
                int k = 0;
                int m = 0;
                int sum = 0;
                int[] key = InttypesOfAnimalsMenu((String) Objects.requireNonNull(myCombo.getSelectedItem()));
                String[] stringKey = StringtypesOfAnimalsMenu(key);
                assert key != null;
                for (int value : key) {
                    sum += names[value].length;
                }
                String[] animalsTypes = new String[sum];
                while (m < key.length) {
                    for (int j = 0; j < names[key[m]].length; ++j) {
                        animalsTypes[k] = names[key[m]][j];
                        k += 1;
                    }
                    m += 1;
                }
                for (String s : stringKey) {
                    myUpdatedCombo.addItem(s);
                }
                myUpdatedCombo.setEnabled(true);
                myUpdatedCombo.addActionListener(e13 -> {
                    designCombo.removeAllItems();
                    designCombo.setEnabled(true);
                    String[] userPick = DesignAnimals((String) Objects.requireNonNull(myUpdatedCombo.getSelectedItem()));
                    animalType1 = (String) myUpdatedCombo.getSelectedItem();
                    for (String s : userPick) {
                        designCombo.addItem(s);
                    }
                    designCombo.addActionListener(e12 -> {
                        selectedSkin = (String) designCombo.getSelectedItem();
                        String path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + selectedSkin + "E.png";
                        BufferedImage img = null;
                        assert img != null;
                        try {
                            img = ImageIO.read(new File(path));
                        } catch (IOException k1) {
                            System.out.println("Cannot load image");
                        }

                        ImageIcon iconLogo = new ImageIcon(path);
                        Image image = iconLogo.getImage();
                        Image modImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        iconLogo = new ImageIcon(modImage);


                        JLabel animalLabel = new JLabel();
                        AddAnimalDialog.remove(animalLabel);
                        AddAnimalDialog.revalidate();
                        AddAnimalDialog.repaint();

                        animalLabel.setIcon(iconLogo);
                        animalLabel.setBounds(15, 105, 200, 200);

                        AddAnimalDialog.add(animalLabel);


                        JLabel info = new JLabel("Animal's personal info:");
                        info.setBounds(100, 300, 200, 20);
                        AddAnimalDialog.add(info);

                        JLabel name = new JLabel("Name:");
                        name.setBounds(15, 330, 50, 20);
                        AddAnimalDialog.add(name);

                        JTextField nameTextField = new JTextField();
                        nameTextField.setBounds(180, 330, 150, 20);
                        AddAnimalDialog.add(nameTextField);


                        JLabel gender = new JLabel("Gender:");
                        gender.setBounds(15, 360, 50, 20);
                        AddAnimalDialog.add(gender);

                        String[] genderOptions = new String[]{"Male", "Female", "Hermaphrodite"};

                        JComboBox<String> genderCombo = new JComboBox<>(genderOptions);
                        genderCombo.setBounds(180, 360, 150, 20);
                        genderCombo.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                myGender = Gender.valueOf((String) genderCombo.getSelectedItem());
                            }
                        });
                        AddAnimalDialog.add(genderCombo);
                        JLabel speed1 = new JLabel("Speed: ");
                        speed1.setBounds(15, 390, 50, 20);
                        AddAnimalDialog.add(speed1);

                        JTextField speedTextField = new JTextField();
                        speedTextField.setBounds(180, 390, 150, 20);

                        AddAnimalDialog.add(speedTextField);

                        JLabel weight1 = new JLabel("Weight: ");
                        weight1.setBounds(15, 420, 150, 20);
                        AddAnimalDialog.add(weight1);

                        JTextField weightTextField = new JTextField();
                        weightTextField.setBounds(180, 420, 150, 20);

                        AddAnimalDialog.add(weightTextField);

                        JLabel medal1 = new JLabel("Medals: ");
                        medal1.setBounds(15, 450, 150, 20);
                        AddAnimalDialog.add(medal1);
                        JLabel medal2 = new JLabel();
                        medal2.setBounds(100, 480, 150, 20);
                        AddAnimalDialog.add(medal2);
                        String[] medalsOptions = new String[]{"no medal", "1", "2", "3", "4", "5"};

                        JComboBox<String> medalsCombo = new JComboBox<>(medalsOptions);
                        medalsCombo.setBounds(180, 450, 150, 20);

                        AddAnimalDialog.add(medalsCombo);

                        JLabel medal3 = new JLabel("Medal: ");
                        medal3.setBounds(15, 510, 150, 20);
                        medal3.setEnabled(false);
                        AddAnimalDialog.add(medal3);


                        String[] medalOptions = new String[]{"gold", "silver", "bronze"};

                        JComboBox<String> medalCombo = new JComboBox<>(medalOptions);
                        medalCombo.setBounds(180, 510, 150, 20);
                        medalCombo.setEnabled(false);

                        AddAnimalDialog.add(medalCombo);


                        JLabel tournament = new JLabel("Tournament: ");
                        tournament.setBounds(15, 540, 150, 20);
                        tournament.setEnabled(false);
                        AddAnimalDialog.add(tournament);

                        JTextField tournamentTextField = new JTextField();
                        tournamentTextField.setBounds(180, 540, 150, 20);
                        AddAnimalDialog.add(tournamentTextField);
                        tournamentTextField.setEnabled(false);

                        JLabel year = new JLabel("Year: ");
                        year.setBounds(15, 570, 150, 20);
                        year.setEnabled(false);
                        AddAnimalDialog.add(year);

                        JTextField yearTextField = new JTextField();
                        yearTextField.setBounds(180, 570, 70, 20);
                        yearTextField.setText("Enter");
                        AddAnimalDialog.add(yearTextField);

                        medalCombo.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                tournamentTextField.setText("");
                                yearTextField.setText("");
                            }
                        });

                        medalsCombo.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!"no medal".equals((String) medalsCombo.getSelectedItem())) {
                                    medal = new Medal[Integer.parseInt((String) medalsCombo.getSelectedItem())];
                                    medal2.setText("Enter " + medalsCombo.getSelectedItem() + " medals:");

                                    medal3.setEnabled(true);
                                    tournament.setEnabled(true);
                                    year.setEnabled(true);

                                    tournamentTextField.setEnabled(true);
                                    yearTextField.setEnabled(true);
                                    medalCombo.setEnabled(true);
                                    medal2.setVisible(true);

                                }
                            }
                        });

                        JButton acceptMedal = new JButton("Accept");
                        acceptMedal.setBounds(255, 570, 75, 20);
                        yearTextField.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!"".equals(yearTextField.getText()) || !"".equals(tournamentTextField.getText())) {
                                    acceptMedal.setEnabled(true);
                                }

                            }
                        });
                        acceptMedal.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String animalMedal = (String) medalCombo.getSelectedItem();
                                String tournament = (String) tournamentTextField.getText();
                                int year = Integer.parseInt(yearTextField.getText());
                                //cleaning
                                medalCombo.setSelectedIndex(0);
                                tournamentTextField.setText("");
                                yearTextField.setText("");
                                medal[medalSize] = new Medal(Medal.myMedal.valueOf(animalMedal), tournament, year);
                                ++medalSize;
                            }
                        });
                        acceptMedal.setEnabled(false);
                        AddAnimalDialog.add(acceptMedal);

                        yearTextField.setEnabled(false);

                        JButton acceptButton = new JButton("Accept");
                        // Additional info
                        String animalkey = (String) designCombo.getSelectedItem();
                        animalkey = animalkey.substring(0, animalkey.length() - 1);

                        switch (animalkey) {
                            case "dog" -> {
                                CreateDog(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "cat" -> {
                                CreateCat(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "snake" -> {
                                CreateSnake(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "alligator" -> {
                                CreateAlligaotr(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "whale" -> {
                                CreateWhale(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "dolphin" -> {
                                CreateDolphin(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "eagle" -> {
                                CreateEagle(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                            case "pigeon" -> {
                                CreatePigeon(AddAnimalDialog, path, nameTextField, speedTextField, weightTextField, acceptButton);
                            }
                        }
                    });
                });
                AddAnimalDialog.revalidate();
                AddAnimalDialog.repaint();
            }


        });
        AddAnimalDialog.setVisible(true);
    }

    /*
    InttypesOfAnimalsMenu method is a helper method that can identify an animal type, and return the relevant int array
    (this array contains the indexes of the relevant animals in the names String)
    @param : key
    @return : new Int[]
     */
    private int[] InttypesOfAnimalsMenu(String key) {
        switch (key) {
            case "Terrestrial Animal" -> {
                return new int[]{1, 2, 3, 4};
            }
            case "Air Animal" -> {
                return new int[]{7, 8};
            }
            case "Water Animal" -> {
                return new int[]{4, 5, 6};
            }
        }
        return null;
    }

    /*
  StringtypesOfAnimalsMenu method is a helper method that can convert s specific int array to a string array
  @param : int[] key
  @return : new String[]
   */
    private String[] StringtypesOfAnimalsMenu(int[] key) {

        if (Arrays.equals(key, new int[]{1, 2, 3, 4})) {
            return new String[]{"Dog", "Cat", "Snake", "Alligator"};
        } else if (Arrays.equals(key, new int[]{4, 5, 6})) {
            return new String[]{"Whale", "Alligator", "Dolphin"};
        } else {
            return new String[]{"Eagle", "Pigeon"};
        }

    }

    /*
    DesignAnimals is a helper method that can decide which element from names need to be taken
    @param : String key
    @return String[] from names;
     */
    private String[] DesignAnimals(String key) {
        switch (key) {
            case "Dog" -> {
                return names[1];
            }
            case "Cat" -> {
                return names[2];
            }
            case "Snake" -> {
                return names[3];
            }
            case "Alligator" -> {
                return names[4];
            }
            case "Whale" -> {
                return names[5];
            }
            case "Dolphin" -> {
                return names[6];
            }
            case "Eagle" -> {
                return names[7];
            }
            case "Pigeon" -> {
                return names[8];
            }
        }
        return new String[]{"kisses"};
    }

    /*
    DisplayAnimal this method is in charge of displaying specific image on the screen
    @param : String path
    @param : boolean flag
     */
    public void DisplayAnimal(String path, boolean flag) throws IOException {
        DrawingComponent animalImg = null;
        int[] result = new int[6];
        result[0] = 0;

        try {

            animalImg = AddImg(path, flag, null);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        int resSize = 0;
        int x = 0;
        int y = 0;
        Random r = new Random();

        switch (selectedType) {
            case "Terrestrial Animal" -> {

                y = 0;
            }
            case "Air Animal" -> {
                int low = 1;
                int high = 5;
                int temp = 0;

                while (contains(result, temp)) {
                    temp = r.nextInt(high - low) + low;
                }
                result[resSize] = temp;
                switch (result[resSize]) {
                    case 1 -> {
                        y = 0;
                    }
                    case 2 -> {
                        y = 185;
                    }
                    case 3 -> {
                        y = 360;
                    }
                    case 4 -> {
                        y = 555;
                    }
                    case 5 -> {
                        y = 730;
                    }
                }
            }
            case "Water Animal" -> {
                if (!myAnimal[animalSize - 1].getClass().getSimpleName().equals("Alligator")) {
                    int low = 1;
                    int high = 4;
                    int temp = 0;
                    while (contains(result, temp)) {
                        temp = r.nextInt(high - low) + low;
                    }
                    result[resSize] = temp;

                    switch (result[resSize]) {
                        case 1 -> {
                            y = 0;
                        }
                        case 2 -> {
                            y = 185;
                        }
                        case 3 -> {
                            y = 360;
                        }
                        case 4 -> {
                            y = 555;
                        }
                    }
                } else {
                    y = 0;
                }
            }
        }

        resSize += 1;
        myAnimal[this.animalSize - 1].setLocation(new Point(x, y));
        assert animalImg != null;
        animalImg.setBounds(x, y, 100, 100);
        myImages[0].add(animalImg);
        validate();
        repaint();
        StartMoving();
    }

    /*
    StartMovingTerrestrial method is in charge to move the terrestrial animals that are not Alligators
     */
    public void StartMovingTerrestrial() throws IOException {
        AddImg(null, true, myAnimal[animalSize - 1].getImg2());
        AddImg(null, true, myAnimal[animalSize - 1].getImg3());
        AddImg(null, true, myAnimal[animalSize - 1].getImg4());
        int curr = imgSize - 4;
        double speed = myAnimal[animalSize - 1].getSpeed();
        TimerTask[] task = new TimerTask[4];
        task[0] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[0]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x <= 1000 && flag) {
                            x = x + speed;
                            myAnimal[animalSize - 1].move(new Point(x, y));
                            myImages[curr].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else if (x > 1000) {
                            myImages[0].remove(myImages[curr]);
                            myImages[0].validate();
                            myImages[0].repaint();
                            task[0].cancel();
                            t[0].schedule(task[1], 50, 100);
                        }
                    }
                }
            }
        };

        task[1] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[1]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                            validate();
                            repaint();
                        }
                        if (y < 730 && flag) {
                            y = y + speed;
                            myImages[curr + 1].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);

                        } else if (y >= 730) {
                            task[1].cancel();
                            myImages[0].remove(myImages[curr + 1]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            t[0].schedule(task[2], 50, 100);
                        }
                    }
                }
            }
        };

        task[2] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[2]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        flag = energy > 0 && energy - energyEater > 0;
                        validate();
                        repaint();
                        if (x > 0 && flag) {
                            x = x - speed;
                            myImages[curr + 2].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else if (x >= 0) {
                            task[2].cancel();
                            myImages[0].remove(myImages[curr + 2]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            t[0].schedule(task[3], 50, 100);
                        }
                    }
                }
            }
        };

        task[3] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[3]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (y > 0 && flag == true) {
                            y = y - speed;
                            myImages[curr + 3].setBounds((int) x, (int) y, 100, 100);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else if (y <= 0) {
                            task[3].cancel();
                            myImages[0].remove(myImages[curr + 3]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                        }
                    }
                }
            }
        };

        t[0] = new java.util.Timer();
        t[0].schedule(task[0], 50, 100);
    }

    /*
    StartMovingTerrestrialAlligator method is in charge to move the terrestrial animals that are Alligators
     */
    public void StartMovingTerrestrialAlligator() throws IOException {

        AddImg(null, true, myAnimal[animalSize - 1].getImg2());
        int curr = imgSize - 2;
        double speed = myAnimal[animalSize - 1].getSpeed();
        TimerTask[] task = new TimerTask[2];
        task[0] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[0]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x < 1000 && flag == true) {
                            x = x + speed;
                            myImages[curr].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else {
                            myImages[0].remove(myImages[curr]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            task[0].cancel();
                            t[1].schedule(task[1], 50, 100);
                        }
                    }
                }
            }
        };

        task[1] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[1]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x > 0 && flag) {
                            x = x - speed;
                            myImages[curr + 1].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else {
                            task[1].cancel();
                            myImages[0].remove(myImages[curr + 1]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                        }
                    }
                }
            }
        };
        t[1] = new java.util.Timer();
        t[1].schedule(task[0], 50, 100);
    }

    /*
    StartMovingWater method is in charge of movig the water animals that are not alligtors
     */
    public void StartMovingWater() throws IOException {
        AddImg(null, true, myAnimal[animalSize - 1].getImg2());
        int curr = imgSize - 2;
        double speed = myAnimal[animalSize - 1].getSpeed();
        TimerTask[] task = new TimerTask[2];
        task[0] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[0]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x < 1000 && flag) {
                            x = x + speed;
                            myImages[curr].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else if (x >= 1000) {
                            myImages[0].remove(myImages[curr]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            task[0].cancel();
                            t[2].schedule(task[1], 50, 100);
                        }
                    }
                }
            }
        };

        task[1] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[1]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x > 0 && flag) {
                            x = x - speed;
                            myImages[curr + 1].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else if (x <= 0) {
                            task[1].cancel();
                            myImages[0].remove(myImages[curr + 1]);
                            myImages[0].revalidate();
                            myImages[0].repaint();

                        }
                    }
                }
            }
        };
        t[2] = new java.util.Timer();
        t[2].schedule(task[0], 100, 100);
    }

    /*
    StartMovingWaterAlligator method is in charge of movig the water animals that are alligtors
     */
    public void StartMovingWaterAlligator() throws IOException {
        AddImg(null, true, myAnimal[animalSize - 1].getImg2());
        int curr = imgSize - 2;
        double speed = myAnimal[animalSize - 1].getSpeed();
        TimerTask[] task = new TimerTask[2];
        task[0] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[0]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x < 1000 && flag) {
                            x = x + speed;
                            myImages[curr].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else {
                            myImages[0].remove(myImages[curr]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            task[0].cancel();
                            t[3].schedule(task[1], 100, 100);
                        }
                    }
                }
            }
        };

        task[1] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[1]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        flag = energy > 0 && energy - energyEater > 0;
                        if (x > 0 && flag) {
                            x = x - speed;
                            myImages[curr + 1].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else {
                            task[1].cancel();
                            myImages[0].remove(myImages[curr + 1]);
                            myImages[0].revalidate();
                            myImages[0].repaint();
                        }
                    }
                }
            }
        };
        t[3] = new java.util.Timer();
        t[3].schedule(task[0], 50, 100);
    }

    /*
    StartMovingAir method is in charge of moving the air animals
     */
    public void StartMovingAir() {
        int curr = imgSize - 1;
        double speed = myAnimal[animalSize - 1].getSpeed();
        TimerTask[] task = new TimerTask[2];
        task[0] = new TimerTask() {
            @Override
            public void run() {
                synchronized (task[0]) {
                    double x = myAnimal[animalSize - 1].getLocation().x;
                    double y = myAnimal[animalSize - 1].getLocation().y;
                    boolean flag = false;
                    int energy = myAnimal[animalSize - 1].getCurrEnergy();
                    int energyEater = myAnimal[animalSize - 1].getEnergyPerMeter();
                    if (energy > 0) {
                        energy -= energyEater;
                        myAnimal[animalSize - 1].Eat();
                        System.out.println("energy level: " + energy);
                        if (energy > 0 && energy - energyEater > 0) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                        if (x < 1000) {
                            x = x + speed;
                            myImages[curr].setBounds((int) x, (int) y, 100, 100);
                            validate();
                            repaint();
                            myAnimal[animalSize - 1].setLocation(new Point((int) x, (int) y));
                            model.setValueAt(energy, 0, 4);
                            model.setValueAt(myAnimal[animalSize - 1].GetAddedEnergy(), 0, 6);
                            model.setValueAt(myAnimal[animalSize - 1].getTotalDistance(), 0, 5);
                        } else {
                            myImages[0].revalidate();
                            myImages[0].repaint();
                            task[0].cancel();
                        }
                    }
                }
            }
        };

        t[4] = new Timer();
        t[4].schedule(task[0], 50, 100);
    }

    /*
    StartMoving method can identify which animal the system need to move
     */
    public void StartMoving() throws IOException {
        if (selectedType.equals("Terrestrial Animal")) {
            if (!myAnimal[animalSize - 1].getClass().getSimpleName().equals("Alligator")) {
                StartMovingTerrestrial();
            } else {
                StartMovingTerrestrialAlligator();
            }
        } else if (selectedType.equals("Water Animal")) {
            if (myAnimal[animalSize - 1].getClass().getSimpleName().equals("Alligator")) {
                StartMovingWaterAlligator();
            } else {
                StartMovingWater();
            }
        } else {
            StartMovingAir();
        }
    }

    /*
    AddImg method is in charge of adding new DrawingComponent that contains an image, into the myImages array, so from there
    the system could get the relevant image and display it on the screen
    @param : String path
    @param : boolean flag
    @param : BufferedImage buff
    @return : new DrawingComponent instance
     */
    public DrawingComponent AddImg(String path, boolean flag, BufferedImage buff) throws IOException {

        if (this.imgSize == 0) {
            this.imgSize += 1;
            this.myImages = new DrawingComponent[1];
            this.myImages[this.imgSize - 1] = new DrawingComponent(path, flag);
        } else if (this.imgSize > 0) {

            DrawingComponent[] temp = new DrawingComponent[this.imgSize];

            for (int i = 0; i < this.imgSize; ++i) {
                temp[i] = this.myImages[i];
            }

            this.imgSize += 1;
            this.myImages = new DrawingComponent[this.imgSize];

            for (int i = 0; i < temp.length; ++i) {
                this.myImages[i] = temp[i];
            }
            if (buff == null) {
                this.myImages[this.imgSize - 1] = new DrawingComponent(path, flag);
                this.myImages[0].add(this.myImages[imgSize - 1]);
                return this.myImages[imgSize - 1];
            } else {
                this.myImages[this.imgSize - 1] = new DrawingComponent(buff, flag);
                this.myImages[0].add(this.myImages[imgSize - 1]);
                return this.myImages[imgSize - 1];
            }

        }
        return null;
    }

    /*
    contains mathod is a helper method that can check if an int array contains an certain int element
    @param : int[] arr
    @param : int x
    @return boolean true/false
     */
    private boolean contains(int[] arr, int x) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }

    /*
    ClearAnimal is a method can can clear an animal from the screen
     */
    private void ClearAnimal() {
        this.myImages[0].remove(this.myImages[this.imgSize - 1]);
        this.imgSize -= 1;
        this.myImages[0].revalidate();
        this.myImages[0].repaint();
    }

    public static void main(String[] args) throws IOException {

        // my playground :))))))

        new CompetitionFrame();
    }

    /*
    CreateDog is a method that can add the relevant fields to create a dog instance
    @param: String path
    @param: JDialog AddAnimalDialog
    @param: JTextField nameTextField
    @param: JTextField speedTextField
    @param: JTextField weightTextField
    @param: JButton acceptButton
     */
    private void CreateDog(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {

        JLabel breed1 = new JLabel("Breed: ");
        breed1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(breed1);

        JTextField breedTextField = new JTextField();
        breedTextField.setBounds(180, 600, 150, 20);

        AddAnimalDialog.add(breedTextField);

        JLabel numOfLegs = new JLabel("Number of legs: ");
        numOfLegs.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(numOfLegs);

        JTextField numOfLegsTextField = new JTextField();
        numOfLegsTextField.setBounds(180, 630, 150, 20);
        AddAnimalDialog.add(numOfLegsTextField);

        AddAnimalDialog.setSize(365, 760);
        acceptButton.setBounds(120, 660, 100, 35);

        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                String breed = breedTextField.getText();
                int legs = Integer.parseInt(numOfLegsTextField.getText());
                try {
                    AddCompetitor(new Dog(breed, legs, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                AddAnimalDialog.dispose();
            }
        });
    }

    /*
 CreateCat is a method that can add the relevant fields to create a cat instance
 @param: String path
 @param: JDialog AddAnimalDialog
 @param: JTextField nameTextField
 @param: JTextField speedTextField
 @param: JTextField weightTextField
 @param: JButton acceptButton
  */
    private void CreateCat(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {
        JLabel castrated1 = new JLabel("Castrated: ");
        castrated1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(castrated1);

        String[] castratedOptions = new String[]{"Yes", "No"};
        JComboBox<String> castratedCombo = new JComboBox<>(castratedOptions);
        castratedCombo.setBounds(180, 600, 150, 20);
        castratedCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                castrated = Boolean.parseBoolean((String) castratedCombo.getSelectedItem());
            }
        });
        AddAnimalDialog.add(castratedCombo);

        JLabel numOfLegs1 = new JLabel("Number of legs: ");
        numOfLegs1.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(numOfLegs1);

        JTextField numOfLegsTextField = new JTextField();
        numOfLegsTextField.setBounds(180, 630, 150, 20);
        AddAnimalDialog.add(numOfLegsTextField);

        acceptButton.setBounds(120, 670, 100, 35);
        AddAnimalDialog.setSize(365, 770);
        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = (String) nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                weight = Double.parseDouble(weightTextField.getText());
                int legs = Integer.parseInt((String) numOfLegsTextField.getText());
                try {
                    AddCompetitor(new Cat(castrated, legs, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AddAnimalDialog.dispose();
            }
        });
    }

    /*
CreateSnake is a method that can add the relevant fields to create a snake instance
@param: String path
@param: JDialog AddAnimalDialog
@param: JTextField nameTextField
@param: JTextField speedTextField
@param: JTextField weightTextField
@param: JButton acceptButton
*/
    private void CreateSnake(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {
        {
            JLabel poisonous = new JLabel("Poisonous: ");
            poisonous.setBounds(15, 600, 150, 20);
            AddAnimalDialog.add(poisonous);

            String[] poisonousOptions = new String[]{"Yes", "No"};
            JComboBox<String> poisonousCombo = new JComboBox<>(poisonousOptions);
            poisonousCombo.setBounds(180, 600, 150, 20);
            AddAnimalDialog.add(poisonousCombo);

            JLabel poisonousDegree = new JLabel("Poisonous Degree: ");
            poisonousDegree.setBounds(15, 630, 150, 20);
            poisonousDegree.setEnabled(false);
            AddAnimalDialog.add(poisonousDegree);

            String[] poisonousDegreeOptions = new String[]{"Low", "Medium", "High"};
            JComboBox<String> poisonousDegreeCombo = new JComboBox<>(poisonousDegreeOptions);
            poisonousDegreeCombo.setBounds(180, 630, 150, 20);
            poisonousDegreeCombo.setEnabled(false);
            poisonousDegreeCombo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    poison = Snake.Poisonous.valueOf((String) poisonousDegreeCombo.getSelectedItem());
                }
            });
            poisonousCombo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    isPoison = (String) poisonousCombo.getSelectedItem();
                    if (isPoison.equals("Yes")) {
                        poisonousDegree.setEnabled(true);
                        poisonousDegreeCombo.setEnabled(true);
                    }
                }
            });

            poisonousDegreeCombo.setEnabled(false);
            AddAnimalDialog.add(poisonousDegreeCombo);

            poisonousCombo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ("Yes".equals(poisonousCombo.getSelectedItem())) {
                        poisonousDegreeCombo.setEnabled(true);
                    }
                }
            });

            JLabel length = new JLabel("Length: ");
            length.setBounds(15, 660, 150, 20);
            AddAnimalDialog.add(length);

            JTextField lengthTextField = new JTextField();
            lengthTextField.setBounds(180, 660, 150, 20);
            AddAnimalDialog.add(lengthTextField);

            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String animalName = (String) nameTextField.getText();
                    double speed = Double.parseDouble(speedTextField.getText());
                    double weight = Double.parseDouble(weightTextField.getText());
                    double length = Double.parseDouble((String) lengthTextField.getText());
                    try {
                        AddCompetitor(new Snake(poison, length, 0, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    try {
                        DisplayAnimal(path, true);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    AddAnimalDialog.dispose();
                }
            });

            AddAnimalDialog.setSize(365, 800);
            acceptButton.setBounds(120, 700, 100, 35);
            AddAnimalDialog.add(acceptButton);
            acceptButton.setEnabled(true);
        }
    }

    /*
  CreateAlligator is a method that can add the relevant fields to create a Alligator instance
  @param: String path
  @param: JDialog AddAnimalDialog
  @param: JTextField nameTextField
  @param: JTextField speedTextField
  @param: JTextField weightTextField
  @param: JButton acceptButton
   */
    private void CreateAlligaotr(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {
        JLabel areaOfLiving1 = new JLabel("Area of living: ");
        areaOfLiving1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(areaOfLiving1);

        JTextField areaOfLivingTextField = new JTextField();
        areaOfLivingTextField.setBounds(180, 600, 150, 20);

        AddAnimalDialog.add(areaOfLivingTextField);

        JLabel depth1 = new JLabel("Depth: ");
        depth1.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(depth1);

        JTextField depthTextField = new JTextField();
        depthTextField.setBounds(180, 630, 150, 20);
        AddAnimalDialog.add(depthTextField);

        JLabel numOfLegs1 = new JLabel("Number of legs: ");
        numOfLegs1.setBounds(15, 660, 150, 20);
        AddAnimalDialog.add(numOfLegs1);

        JTextField numOfLegsTextField = new JTextField();
        numOfLegsTextField.setBounds(180, 660, 150, 20);
        AddAnimalDialog.add(numOfLegsTextField);

        AddAnimalDialog.setSize(365, 800);
        acceptButton.setBounds(120, 700, 100, 35);
        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                int legs = Integer.parseInt(numOfLegsTextField.getText());
                String areaOfLiving = areaOfLivingTextField.getText();
                double depth = Double.parseDouble(depthTextField.getText());
                try {
                    AddCompetitor(new Alligator(legs, areaOfLiving, depth, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AddAnimalDialog.dispose();
            }
        });
    }

    /*
  CreateWhale is a method that can add the relevant fields to create a whale instance
  @param: String path
  @param: JDialog AddAnimalDialog
  @param: JTextField nameTextField
  @param: JTextField speedTextField
  @param: JTextField weightTextField
  @param: JButton acceptButton
   */
    private void CreateWhale(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {

        JLabel depth1 = new JLabel("Depth: ");
        depth1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(depth1);

        JTextField depthTextField = new JTextField();
        depthTextField.setBounds(180, 600, 150, 20);

        AddAnimalDialog.add(depthTextField);

        JLabel foodType1 = new JLabel("Food type: ");
        foodType1.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(foodType1);

        JTextField foodTypeTextField = new JTextField();
        foodTypeTextField.setBounds(180, 630, 150, 20);
        AddAnimalDialog.add(foodTypeTextField);

        AddAnimalDialog.setSize(365, 760);
        acceptButton.setBounds(120, 660, 100, 35);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                double depth = Double.parseDouble(depthTextField.getText());
                String foodType = foodTypeTextField.getText();
                try {
                    AddCompetitor(new Whale(foodType, depth, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AddAnimalDialog.dispose();
            }
        });
        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);

    }

    /*
CreateDolphin is a method that can add the relevant fields to create a dolphin instance
@param: String path
@param: JDialog AddAnimalDialog
@param: JTextField nameTextField
@param: JTextField speedTextField
@param: JTextField weightTextField
@param: JButton acceptButton
*/
    private void CreateDolphin(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {


        JLabel depth1 = new JLabel("Depth:");
        depth1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(depth1);

        JTextField depthTextField = new JTextField();
        depthTextField.setBounds(180, 600, 150, 20);
        AddAnimalDialog.add(depthTextField);

        JLabel waterType1 = new JLabel("Water type: ");
        waterType1.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(waterType1);

        String[] waterTypeOptions = new String[]{"Sea", "Sweet"};
        JComboBox<String> waterTypeCombo = new JComboBox<>(waterTypeOptions);
        waterTypeCombo.setBounds(180, 630, 150, 20);
        AddAnimalDialog.add(waterTypeCombo);

        AddAnimalDialog.setSize(365, 770);
        acceptButton.setBounds(120, 670, 100, 35);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                double depth = Double.parseDouble(depthTextField.getText());
                Dolphin.WaterType waterType = Dolphin.WaterType.valueOf((String) waterTypeCombo.getSelectedItem());
                try {
                    AddCompetitor(new Dolphin(waterType, depth, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AddAnimalDialog.dispose();
            }
        });
        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);
    }

    /*
CreateEagle is a method that can add the relevant fields to create a eagle instance
@param: String path
@param: JDialog AddAnimalDialog
@param: JTextField nameTextField
@param: JTextField speedTextField
@param: JTextField weightTextField
@param: JButton acceptButton
*/
    private void CreateEagle(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {
        JLabel altitudeOfFlight1 = new JLabel("Altitude of flight:");
        altitudeOfFlight1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(altitudeOfFlight1);

        JTextField altitudeOfFlightTextField = new JTextField();
        altitudeOfFlightTextField.setBounds(180, 600, 150, 20);
        AddAnimalDialog.add(altitudeOfFlightTextField);

        JLabel wingSpan1 = new JLabel("Wing span:");
        wingSpan1.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(wingSpan1);

        JTextField wingSpanTextField = new JTextField();
        wingSpanTextField.setBounds(180, 630, 150, 20);
        AddAnimalDialog.add(wingSpanTextField);

        AddAnimalDialog.setSize(365, 770);
        acceptButton.setBounds(120, 670, 100, 35);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                double altitudeOfFlight = Double.parseDouble(altitudeOfFlightTextField.getText());
                double wingSpan = Double.parseDouble(wingSpanTextField.getText());
                try {
                    AddCompetitor(new Eagle(altitudeOfFlight, wingSpan, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AddAnimalDialog.dispose();
            }
        });

        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);
    }

    /*
CreatePigeon is a method that can add the relevant fields to create a pigeon instance
@param: String path
@param: JDialog AddAnimalDialog
@param: JTextField nameTextField
@param: JTextField speedTextField
@param: JTextField weightTextField
@param: JButton acceptButton
*/
    private void CreatePigeon(JDialog AddAnimalDialog, String path, JTextField nameTextField, JTextField speedTextField, JTextField weightTextField, JButton acceptButton) {
        JLabel family1 = new JLabel("Family:");
        family1.setBounds(15, 600, 150, 20);
        AddAnimalDialog.add(family1);

        JTextField familyTextField = new JTextField();
        familyTextField.setBounds(180, 600, 150, 20);
        AddAnimalDialog.add(familyTextField);

        JLabel wingSpan1 = new JLabel("Wing span:");
        wingSpan1.setBounds(15, 630, 150, 20);
        AddAnimalDialog.add(wingSpan1);

        JTextField wingSpanTextField = new JTextField();
        wingSpanTextField.setBounds(180, 630, 150, 20);

        AddAnimalDialog.add(wingSpanTextField);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalName = nameTextField.getText();
                double speed = Double.parseDouble(speedTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                String family = familyTextField.getText();
                double wingSpan = Double.parseDouble(wingSpanTextField.getText());
                try {
                    AddCompetitor(new Pigeon(family, wingSpan, animalName, myGender, weight, speed, medal, new Point(0, 0), selectedType, selectedSkin, 50, 5));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    DisplayAnimal(path, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                AddAnimalDialog.dispose();
            }
        });

        AddAnimalDialog.setSize(365, 760);
        acceptButton.setBounds(120, 660, 100, 35);
        AddAnimalDialog.add(acceptButton);
        acceptButton.setEnabled(true);

    }
}





