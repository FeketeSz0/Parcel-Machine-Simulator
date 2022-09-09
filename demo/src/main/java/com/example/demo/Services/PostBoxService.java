package com.example.demo.Services;

import com.example.demo.Repositories.PostBoxRepo;
import com.example.demo.modells.PostBox;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostBoxService {

    private final PostBoxRepo postBoxRepo;



    //create a hard coded postbox name A
    public void postBoxA() {
               PostBox postBox1 = new PostBox(
                "A",5,5,0,0);
        postBoxRepo.save(postBox1);
    }



    //add item into the queue
    public void InComingPackage(String name) {
        Optional<PostBox> postbox = postBoxRepo.findByName(name);
        postbox.get().setInQueue(postbox.get().getInQueue() + 1);
    }



    //add item to the box
    public void addiItem(String name) {
        Optional<PostBox> postbox = postBoxRepo.findByName(name);
        postbox.get().setFreeSpace(postbox.get().getFreeSpace() - 1);
        postbox.get().setUsedSpace(postbox.get().getUsedSpace() + 1);
         postbox.get().setInQueue(postbox.get().getInQueue() - 1);

    }


    //removes item from the box
    public void removeItem(String name) {
        Optional<PostBox> postBox = postBoxRepo.findByName(name);
        postBox.get().setFreeSpace(postBox.get().getFreeSpace() + 1);
        postBox.get().setUsedSpace(postBox.get().getUsedSpace() - 1);
        }


    //checks if there is space for the package
    public boolean CapacityChecker(String choosebox) {
        Optional<PostBox> postBox = postBoxRepo.findByName(choosebox);
        Integer freespace = postBox.get().getFreeSpace();
        if (freespace > 0) {
            return true;
        }else {throw new IllegalStateException("No space");}

    }



    public List<PostBox> listofboxes() {
      List<PostBox> postboxList = postBoxRepo.findAll();
      return postboxList;
    }
}



