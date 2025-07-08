// Handle student login
document.getElementById('login-form').addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Send login request to backend
    fetch(`http://localhost:8080/api/students/login?email=${email}`, {
        method: 'GET',
        headers: {
            'Authorization': 'Basic ' + btoa('user:password')
        }
    })
        .then(response => response.json())
        .then(data => {
            if (data) {
                localStorage.setItem('student', JSON.stringify(data));
                window.location.href = 'dashboard.html';
            } else {
                alert('Invalid credentials');
            }
        })
        .catch(error => console.error('Error:', error));
});

// Fetch courses from backend
function fetchCourses() {
    fetch('http://localhost:8080/api/courses/all')
        .then(response => response.json())
        .then(courses => {
            const courseList = document.getElementById('course-list');
            courses.forEach(course => {
                const courseItem = document.createElement('div');
                courseItem.classList.add('course');
                courseItem.innerHTML = `
                    <h3>${course.name}</h3>
                    <p>${course.description}</p>
                    <button onclick="enrollCourse(${course.id})">Enroll</button>
                `;
                courseList.appendChild(courseItem);
            });
        });
}

// Enroll student in course
function enrollCourse(courseId) {
    const student = JSON.parse(localStorage.getItem('student'));

    fetch('http://localhost:8080/api/enrollments/enroll', {
        method: 'POST',
        body: JSON.stringify({
            email: student.email,
            courseId: courseId
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            alert('Successfully enrolled in the course!');
            window.location.href = 'courses.html';
        })
        .catch(error => console.error('Error:', error));
}

// Logout
function logout() {
    localStorage.clear();
    window.location.href = 'index.html';
}
