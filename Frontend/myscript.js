function showCourses()
{
    fetch("http://localhost:8080/courses")
    .then(response => response.json())
    .then(courses => {
        const courseList = document.getElementById("coursetable");
        courses.forEach(course => {
            var row = `<tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`;
            courseList.innerHTML += row;
        });
    })
    .catch(error => {
        console.error("Error fetching courses:", error);
    });
}

function showEnrolledStudents(){
    fetch("http://localhost:8080/courses/enrolled")
    .then(response => response.json())
    .then(students => {
        const studentList = document.getElementById("enrolledtable");
        students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.emailId}</td>
            <td>${student.courseName}</td>
            </tr>`;
            studentList.innerHTML += row;
        });
    })
    .catch(error => {
        console.error("Error fetching enrolled students:", error);
    });
}