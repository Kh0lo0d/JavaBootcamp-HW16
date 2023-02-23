package com.example.project_madison.Service;

import com.example.project_madison.Exception.ApiException;
import com.example.project_madison.Model.Link;
import com.example.project_madison.Model.Madison;
import com.example.project_madison.Model.Patient;
import com.example.project_madison.Model.Request;
import com.example.project_madison.Repository.LinkRepository;
import com.example.project_madison.Repository.RecuestRepositry;
import com.example.project_madison.Repository.RepositoryMadison;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServer {

    private final RecuestRepositry requestRepository;
    private  final RepositoryMadison medicineRepository;
    private final LinkRepository linkRepository;
    private  final PatientService patientService;

    public List<Request> getRequest(){
        return requestRepository.findAll();
    }

    public void addRequest(Request request){

        request.setStatus("waiting");
  /*      Link link = null;
        link.setRequestId( request.getMedicineId());
        link.setMedicineId( request.getId());
        linkRepository.save(link);*/
        requestRepository.save(request);
    }


    public void updateRequest(Integer id, Request request){
        Request old = requestRepository.findRequestById(id);
        if (old==null) {
            throw new ApiException(" Request not found");

        }
        old.setStatus(request.getStatus());
        old.setQuantity(request.getQuantity());
        old.setPatientId(request.getPatientId());
        old.setHospitalId(request.getHospitalId());
        old.setMedicineId(request.getMedicineId());
        old.setTotalPrice(request.getTotalPrice());

        requestRepository.save(old);

    }

    public void deleteRequest(Integer id){

        Request old = requestRepository.findRequestById(id);
        if (old!=null) {
            requestRepository.deleteById(id);
        }
        throw new ApiException(" Request not found");


    }

    public void totalPrice( Integer requestId){

        Madison itemPrice;
        Request updated = requestRepository.findRequestById(requestId);
        double total=0.0;

        if (updated==null) {
            throw new ApiException(" Request not found");

        }


        //  List<Link> links = linkRepository.findAllByRequestId(updated.getId());
      //  Link link = linkRepository.findByRequestId(updated.getId());


        //    for(int i=0; links.; i++ )
        //    {


        itemPrice=  medicineRepository.findMedicineById(updated.getMedicineId());

        total= total+ itemPrice.getPrice();


        //  }

        updated.setTotalPrice(total);

    }


    public void checkStatus(Integer id)
    {
        Request request = requestRepository.findRequestById(id);
        if (request==null) {
            throw new ApiException(" Request not found");
        }
        int patientId= request.getPatientId();
        int MedicineId= request.getMedicineId();

        Patient patient= patientService.patientRepository.findPatientByPatientId(patientId);
        Madison medicine= medicineRepository.findMedicineById(MedicineId);

        if(medicine.getQuantity()>=request.getQuantity())
        {
            if (medicine.getPrice() >= patient.getBalance())
                request.setStatus("approved");

        }

        throw new ApiException("No balance or quantity !");


    }
    public void Statustoscheduled(Integer id, Request requests) {
        Request request = requestRepository.getById(id);
        if (request != null && request.getEmergencyLevel().equals("normal") || request.getEmergencyLevel().equals("rush") && request.getStatus().equals("approved")) {
            request.setStatus("scheduled");
            //deliveryScheduleRepository.save(delivery);
        }
        request.getStatus();
        requestRepository.save(requests);
    }

}
