import React, { useState } from 'react';
import './Dashboard.css'
// import Footer from './Footer';
// import Sidebar from './Sidebar';
// import DashNavbar from './DashNavbar';

const Dashboard = () => {
  const [entries, setEntries] = useState([]);
  const [newEntry, setNewEntry] = useState({ name: '', staffid: '' , startTime: '', endTime: '', class: ''});
  const [editIndex, setEditIndex] = useState(-1);
  const [editEntry, setEditEntry] = useState({ name: '', staffid: '' , startTime: '', endTime: '', class: ''});

  const handleChange = (e) => {
    e.preventDefault();
    const { name, value } = e.target;
    if (editIndex !== -1) {
      setEditEntry({ ...editEntry, [name]: value });
    } else {
      setNewEntry({ ...newEntry, [name]: value });
    }
  };

  const handleAdd = (e) => {
    e.preventDefault();
    if (newEntry.name && newEntry.staffid && newEntry.startTime && newEntry.endTime && newEntry.class) {
      setEntries([...entries, newEntry]);
      setNewEntry({ name: '', staffid: '', startTime: '', endTime: '', class: '' });
    }
  };

  const handleRemove = (index) => {
    const updatedEntries = entries.filter((entry, i) => i !== index);
    setEntries(updatedEntries);
  };

  const handleEdit = (index) => {
    setEditIndex(index);
    setEditEntry(entries[index]);
  };

  const handleSave = (e) => {
    e.preventDefault();
    const updatedEntries = entries.map((entry, i) => (i === editIndex ? editEntry : entry));
    setEntries(updatedEntries);
    setEditIndex(-1);
    setEditEntry({ name: '', staffid: '', startTime: '', endTime: '',class: ''});
  };

  return (
    <div>
      {/* <DashNavbar/>
      <Sidebar/> */}
      <div className="dashboardbody">
        <h1>Scheduleboard</h1>
        <section className='dashboard-section'>
          <h4>Use the below Table to add or remove schedules for your "Staff"</h4>
        </section>
        <form onSubmit={editIndex === -1 ? handleAdd : handleSave} className='dashboardform'>
          <input
            type="text"
            name="name"
            placeholder="Enter Staff Name"
            value={editIndex === -1 ? newEntry.name : editEntry.name}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="staffid"
            placeholder="Enter Staff-Id"
            value={editIndex === -1 ? newEntry.staffid : editEntry.staffid}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="class"
            placeholder="Enter time-Schedule"
            value={editIndex === -1 ? newEntry.class : editEntry.class}
            onChange={handleChange}
            required
          />
          <input
            type="time"
            name="startTime"
            placeholder='Choose start time'
            value={editIndex === -1 ? newEntry.startTime : editEntry.startTime}
            onChange={handleChange}
            required
          />
          <input
            type="time"
            name="endTime"
            placeholder='Choose end time'
            value={editIndex === -1 ? newEntry.endTime : editEntry.endTime}
            onChange={handleChange}
            required
          />
          <button type="submit">{editIndex === -1 ? 'Schedule' : 'Save'}</button>
        </form>
        <section className='features-section'>
          <table className='dashboardtable'>
            <thead>
              <tr>
                <th>Name</th>
                <th>Staff-Id</th>
                <th>Schedule</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {entries.map((entry, index) => (
                <tr key={index}>
                  <td>{entry.name}</td>
                  <td>{entry.staffid}</td>
                  <td>{entry.class}</td>
                  <td>{entry.startTime}</td>
                  <td>{entry.endTime}</td>
                  <td>
                    <button onClick={() => handleRemove(index)}>Remove</button>
                    <button onClick={() => handleEdit(index)}>Edit</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </section>
      </div>
      {/* <Footer/> */}
    </div>
  );
};

export default Dashboard;