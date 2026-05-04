import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { CommonModule } from '@angular/common';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
  export class EmployeeListComponent implements OnInit {
  
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService, private router: Router){}
    ngOnInit(): void{
      this.getEmployees();
    }
    
    private getEmployees(){
      this.employeeService.getEmployeeList().subscribe({
    next: (data) => {
      this.employees = data;
    },
    error: (err) => console.log(err)
  });
}
    employeeDetails(id: number){
      this.router.navigate(['/employee-details', id]); 
    }
    updateEmployee(id: number){
      if (this.router.url !== `/update-employee/${id}`) {
    this.router.navigate(['/update-employee', id]);
  }
    }

    deleteEmployee(id: number){
      this.employeeService.deleteEmployee(id).subscribe(data=>{
        console.log(data);
        this.getEmployees();
      })
    }
}