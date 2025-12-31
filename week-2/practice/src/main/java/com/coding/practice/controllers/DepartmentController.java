package com.coding.practice.controllers;

import com.coding.practice.dto.DepartmentDTO;
import com.coding.practice.exceptions.ResourceNotFoundException;
import com.coding.practice.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController()
@RequestMapping("/department")
public class DepartmentController {


    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId ){

        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(departmentId);
        return departmentDTO
                .map( departmentDTO1 ->  ResponseEntity.ok(departmentDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department Not found!"));
    }

    @GetMapping()
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();

    }

    @PostMapping()
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){

        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);

        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity deleteDepartment(@PathVariable @Valid Long departmentId ){

        departmentService.deleteDepartment(departmentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable @Valid Long departmentId,
                                                          @RequestBody DepartmentDTO departmentDTO){

        return ResponseEntity.ok(departmentService.updateDepartment(departmentId, departmentDTO));

    }

}
