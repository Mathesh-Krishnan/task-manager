import React, { useState } from "react";

function AddTask({ addTask, users }) {
  const [task, setTask] = useState({
    title: "",
    description: "",
    dueDate: "", // DD-MM-YYYY format
    userId: "",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!task.title || !task.dueDate || !task.userId) {
      alert("Please fill all required fields!");
      return;
    }

    // Validate date format (DD-MM-YYYY)
    const dateRegex = /^\d{2}-\d{2}-\d{4}$/;
    if (!dateRegex.test(task.dueDate)) {
      alert("Please enter date in DD-MM-YYYY format (e.g., 15-09-2025).");
      return;
    }

    addTask(task);
    setTask({ title: "", description: "", dueDate: "", userId: "" });
  };

  return (
    <form onSubmit={handleSubmit} className="card">
      <h2>Add Task</h2>

      <input
        type="text"
        placeholder="Task title"
        value={task.title}
        onChange={(e) => setTask({ ...task, title: e.target.value })}
      />

      <input
        type="text"
        placeholder="Task description"
        value={task.description}
        onChange={(e) => setTask({ ...task, description: e.target.value })}
      />

      <input
        type="text"
        placeholder="DD-MM-YYYY"
        value={task.dueDate}
        onChange={(e) => setTask({ ...task, dueDate: e.target.value })}
      />

      <select
        value={task.userId}
        onChange={(e) => setTask({ ...task, userId: e.target.value })}
      >
        <option value="">-- Assign To --</option>
        {users.map((user) => (
          <option key={user.id} value={user.id}>
            {user.username} ({user.email})
          </option>
        ))}
      </select>

      <button type="submit">➕ Add Task</button>
    </form>
  );
}

export default AddTask;
