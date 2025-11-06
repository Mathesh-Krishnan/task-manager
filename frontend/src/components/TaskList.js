import React from "react";

function TaskList({ tasks, deleteTask }) {
  return (
    <div className="list">
      <h2>Tasks</h2>
      {tasks.length === 0 ? (
        <p>No tasks available</p>
      ) : (
        <ul>
          {tasks.map((task) => (
            <li key={task.id} className="task-card">
              <strong>{task.title}</strong> — {task.description}
              <br />
              📅 Due: {task.dueDate}
              <br />
              👤 Assigned to: {task.user ? task.user.username : "Unassigned"}
              <br />
              📧 Email: {task.user ? task.user.email : "N/A"}
              <br />
              <button onClick={() => deleteTask(task.id)}>🗑 Delete</button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default TaskList;
