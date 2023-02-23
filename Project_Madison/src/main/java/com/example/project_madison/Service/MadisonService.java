package com.example.project_madison.Service;

import com.example.project_madison.Model.Madison;
import com.example.project_madison.Repository.RepositoryMadison;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MadisonService {

  private final RepositoryMadison repositoryMadison;

    public List getAllMadison() {

        return repositoryMadison.findAll();
    }

    public void addMadison(Madison madison) {

        repositoryMadison.save(madison);
    }

    public boolean updateMadison(Integer id,Madison madison){

Madison oldMadison=repositoryMadison.getById(id);
if(oldMadison==null){
    return false;}

    oldMadison.setName(madison.getName());
oldMadison.setPrice(madison.getPrice());
oldMadison.setExpire(madison.getExpire());
oldMadison.setQuantity(madison.getQuantity());
repositoryMadison.save(oldMadison);

return true;
    }

    public boolean deleteMadison(Integer id) {
        Madison oldMadison=repositoryMadison.getById(id);
        if (oldMadison == null) {
            return false;
        } else
        repositoryMadison.deleteById(id);
        return true;

    }
public Date getEXpire(Integer id,String name)
{
    Madison oldMadison=repositoryMadison.getById(id);
oldMadison.setName(name);
return  oldMadison.getExpire();



}



}
