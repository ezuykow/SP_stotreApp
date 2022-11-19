package ru.ezuykow.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezuykow.app.models.Bucket;
import ru.ezuykow.app.models.Item;

import java.util.Optional;
import java.util.TreeSet;

@Service
public class BucketService {

    private static final int DEFAULT_COUNT = 1;
    private final Bucket bucket;

    @Autowired
    public BucketService(Bucket bucket) {
        this.bucket = bucket;
    }

    public TreeSet<Item> getItems() {
        return bucket;
    }

    public void addItems(int[] ids) {
        for (int id : ids) {
            addItemToBucketOrEdit(new Item(id));
        }
    }

    private void addItemToBucketOrEdit(Item item) {
        Optional<Item> oldItem = bucket.stream()
                .filter(i -> i.getItemId() == item.getItemId())
                .findAny();
        oldItem.ifPresentOrElse(Item::incCount, () -> bucket.add(item));
    }
}
