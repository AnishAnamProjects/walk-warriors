package com.example.walkwarriors;

import java.util.ArrayList;
import java.util.Random;

public class ChestSystem {
    private static final double COMMON_WEIGHT = 60;
    private static final double RARE_WEIGHT = 35;
    private static final double EPIC_WEIGHT = 5;
    private static double commonCumulativeWeight;
    private static double rareCumulativeWeight;
    private static double epicCumulativeWeight;
    private ArrayList<Equipment> commonEquipments;
    private ArrayList<Equipment> rareEquipments;
    private ArrayList<Equipment> epicEquipments;

    public ChestSystem(ArrayList<Equipment> equipments) {
        commonEquipments = new ArrayList<>();
        rareEquipments = new ArrayList<>();
        epicEquipments = new ArrayList<>();
        double sumWeight = COMMON_WEIGHT + RARE_WEIGHT + EPIC_WEIGHT;
        commonCumulativeWeight = COMMON_WEIGHT / sumWeight;
        rareCumulativeWeight = commonCumulativeWeight + (RARE_WEIGHT / sumWeight);
        epicCumulativeWeight = rareCumulativeWeight + (EPIC_WEIGHT / sumWeight);
        for (Equipment item : equipments) {
            switch(item.getRarity()) {
                case COMMON:
                    commonEquipments.add(item);
                    return;
                case RARE:
                    rareEquipments.add(item);
                    return;
                default: // case EPIC:
                    epicEquipments.add(item);
                    return;
            }
        }
    }

    private Rarity determineRarity() {
        Random rng = new Random();
        double weight = rng.nextDouble();
        if (weight <= commonCumulativeWeight) {
            return Rarity.COMMON;
        } else if (weight <= rareCumulativeWeight) {
            return Rarity.RARE;
        } else { // weight <= EPIC_CUMULATIVE_WEIGHT
            return Rarity.EPIC;
        }

    }

    /**\
     * Opens a chest containing a random equipment based on the weights
     * @return the Equipment item found
     */
    public Equipment openChest(){
        Random rng = new Random();
        switch (determineRarity()) {
            case COMMON: {
                int index = rng.nextInt(commonEquipments.size());
                return commonEquipments.get(index);
            }
            case RARE: {
                int index = rng.nextInt(rareEquipments.size());
                return rareEquipments.get(index);
            }
            default: { // case EPIC
                int index = rng.nextInt(epicEquipments.size());
                return epicEquipments.get(index);
            }
        }
    }


}

