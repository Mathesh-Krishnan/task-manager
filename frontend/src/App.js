import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";
import AddTask from "./components/AddTask";
import TaskList from "./components/TaskList";

function App() {
  const [tasks, setTasks] = useState([]);
  const [users, setUsers] = useState([]);

  // Fetch tasks & users from backend
  useEffect(() => {
    fetchTasks();
    fetchUsers();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/tasks");
      setTasks(response.data);
    } catch (error) {
      console.error("Error fetching tasks:", error);
    }
  };

  const fetchUsers = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/users");
      setUsers(response.data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  const addTask = async (task) => {
  try {
    // Convert DD-MM-YYYY → YYYY-MM-DDT00:00:00
    const [dd, mm, yyyy] = task.dueDate.split("-");
    const formattedDate = `${yyyy}-${mm}-${dd}T00:00:00`;

    await axios.post("http://localhost:8080/api/tasks", {
      title: task.title,
      description: task.description,
      dueDate: formattedDate,
      completed: false,
      user: { id: parseInt(task.userId, 10) },
    });

    fetchTasks();
  } catch (error) {
    console.error("Error adding task:", error);
  }
};


  const deleteTask = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/tasks/${id}`);
      fetchTasks();
    } catch (error) {
      console.error("Error deleting task:", error);
    }
  };

  return (
    <div className="App">
      <h1>📋 Task Manager</h1>

      <AddTask addTask={addTask} users={users} />
      <TaskList tasks={tasks} deleteTask={deleteTask} />
    </div>
  );
}

export default App;
