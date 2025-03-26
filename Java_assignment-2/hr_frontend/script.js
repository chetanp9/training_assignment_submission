const API_URL = "http://localhost:8078";  


function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    fetch(`${API_URL}/hr/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    })
    .then(res => res.json())
    .then(data => {
        if (data.status === "success") {
            localStorage.setItem("token", data.token);
            window.location.href = "dashboard.html"; 
        } else {
            document.getElementById("error-msg").innerText = "Invalid credentials!";
        }
    })
    .catch(err => console.error(err));
}

function logout() {
    const token = localStorage.getItem("token");
    fetch(`${API_URL}/hr/logout`, {
        method: "POST",
        headers: { "Authorization": token }
    })
    .then(() => {
        localStorage.removeItem("token");
        window.location.href = "index.html";
    })
    .catch(err => console.error(err));
}

function fetchEmployees() {
    fetch(`${API_URL}/employees`, {
        headers: { "Authorization": localStorage.getItem("token") }
    })
    .then(response => response.json())
    .then(data => {
        const table = document.getElementById("employeeTable");
        table.innerHTML = "";
        data.forEach(emp => {
            let row = `<tr>
                <td>${emp.name}</td>
                <td>${emp.department}</td>
                <td>${emp.email}</td>
                <td>${emp.salary}</td>
                <td>
                    <button class="edit-btn" onclick="showEditModal(${emp.id}, '${emp.name}', '${emp.department}', '${emp.email}', '${emp.salary}')">Edit</button>
                    <button class="delete-btn" onclick="deleteEmployee(${emp.id})">Delete</button>
                </td>
            </tr>`;
            table.innerHTML += row;
        });
    });
}

function addEmployee() {
    let employee = {
        name: document.getElementById("name").value,
        department: document.getElementById("department").value,
        email: document.getElementById("email").value,
        salary: document.getElementById("salary").value
    };

    fetch(`${API_URL}/employees`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": localStorage.getItem("token")
        },
        body: JSON.stringify(employee)
    })
    .then(response => response.json())
    .then(() => {
        fetchEmployees();
        document.getElementById("name").value = "";
        document.getElementById("department").value = "";
        document.getElementById("email").value = "";
        document.getElementById("salary").value = "";
    });
}

function deleteEmployee(id) {
    fetch(`${API_URL}/employees/${id}`, {
        method: "DELETE",
        headers: { "Authorization": localStorage.getItem("token") }
    })
    .then(() => fetchEmployees());
}

function showEditModal(id, name, department, email, salary) {
    document.getElementById("editName").value = name;
    document.getElementById("editDepartment").value = department;
    document.getElementById("editEmail").value = email;
    document.getElementById("editSalary").value = salary;
    editEmployeeId = id;
    document.getElementById("editModal").style.display = "block";
}

function closeModal() {
    document.getElementById("editModal").style.display = "none";
}

function updateEmployee() {
    let updatedEmployee = {
        name: document.getElementById("editName").value,
        department: document.getElementById("editDepartment").value,
        email: document.getElementById("editEmail").value,
        salary: document.getElementById("editSalary").value
    };

    fetch(`${API_URL}/employees/${editEmployeeId}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
            "Authorization": localStorage.getItem("token")
        },
        body: JSON.stringify(updatedEmployee)
    })
    .then(() => {
        fetchEmployees();
        closeModal();
    });
}

function logout() {
    localStorage.removeItem("token");
    window.location.href = "index.html";
}

fetchEmployees();