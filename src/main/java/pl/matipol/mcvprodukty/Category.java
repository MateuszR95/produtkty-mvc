package pl.matipol.mcvprodukty;

public enum Category {

    GROCERIES("Art. spożywcze"),
    HOUSEHOLD_ITEMS("Art. gospodarstwa domowego"),
    OTHER("Inne");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
