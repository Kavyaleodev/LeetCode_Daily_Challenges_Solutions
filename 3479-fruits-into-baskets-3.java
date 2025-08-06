class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        List<Integer> sectorMaxList = new ArrayList<>();
        int totalBaskets = baskets.length;
        int sectorSize = (int) Math.sqrt(totalBaskets);
        int count = 0;
        int currentMax = 0;
        for (int i = 0; i < totalBaskets; i++) {
            if (count == sectorSize) {
                sectorMaxList.add(currentMax);
                currentMax = baskets[i];
                count = 1;
            } else {
                count++;
                currentMax = Math.max(currentMax, baskets[i]);
            }
        }
        sectorMaxList.add(currentMax);
        int unplacedFruits = 0;
        for (int i = 0; i < fruits.length; i++) {
            int sectorIndex = 0;
            boolean isPlaced = false;

            for (int j = 0; j < totalBaskets; j += sectorSize) {
                if (sectorMaxList.get(sectorIndex) < fruits[i]) {
                    sectorIndex++;
                    continue;
                }
                for (int k = j; k < Math.min(j + sectorSize, totalBaskets); k++) {
                    if (baskets[k] >= fruits[i]) {
                        baskets[k] = 0;
                        isPlaced = true;
                        sectorMaxList.set(sectorIndex, 0);
                        for (int x = j; x < Math.min(j + sectorSize, totalBaskets); x++) {
                            sectorMaxList.set(sectorIndex, Math.max(baskets[x], sectorMaxList.get(sectorIndex)));
                        }
                        break;
                    }
                }
                if (isPlaced) break;
                sectorIndex++;
            }
            if (!isPlaced) unplacedFruits++;
        }
        return unplacedFruits;
    }
}
