package com.coding.practice.services;

import com.coding.practice.dto.DepartmentDTO;
import com.coding.practice.entities.Department;
import com.coding.practice.exceptions.ResourceNotFoundException;
import com.coding.practice.repositories.DepartmentRepository;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {


    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<DepartmentDTO> getDepartmentById(Long departmentId) {

        return departmentRepository.findById(departmentId).map(
                department -> modelMapper.map( department, DepartmentDTO.class));
    }

    public DepartmentDTO createDepartment(@Valid DepartmentDTO departmentDTO) {

        Department departmentToCreate = modelMapper.map( departmentDTO, Department.class);
        Department savedDepartment =  departmentRepository.save(departmentToCreate);

        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public List<DepartmentDTO> getAllDepartments() {

        List<Department> departmentList = departmentRepository.findAll();
        return departmentList
                .stream()
                .map(department ->  modelMapper.map(department, DepartmentDTO.class))
                .toList();
    }

    public void deleteDepartment(@Valid Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    public @Nullable DepartmentDTO updateDepartment(@Valid Long departmentId, DepartmentDTO departmentDTO) {

        Optional<Department> department = Optional.ofNullable(departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("department not found!")
        ));

        Department updateDepartment = modelMapper.map(departmentDTO, Department.class);
        updateDepartment.setDepartmentId(departmentId);
        Department savedDepartment = departmentRepository.save(updateDepartment);

        return modelMapper.map(savedDepartment, DepartmentDTO.class);


    }
}
