package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

public class DBOperations {
	boolean test;
	Connection con = null;
	Complaints c;
	UserDetails u;

	public DBOperations() {
		test = connection();
	}

	public boolean connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/cars_collection?useSSL=false", "root",
					"root");

		} catch (Exception e2) {
			System.out.println(e2);
			return false;
		}

		return true;
	}

	public boolean insertion(Complaints c) {
		try {
			if (test) {
				String exp = "insert into complaint (category,issue,description,cmethod,requestedby,status,comments) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setString(1, c.getCategory());
				ps.setString(2, c.getIssue());
				ps.setString(3, c.getDescription());
				ps.setString(4, c.getCmethod());
				ps.setString(5, c.getRequestedby());
				ps.setString(6, "Open");
				ps.setString(7, c.getComments());

				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			return false;
		}
	}

	public boolean update(Complaints c) {
		try {
			if (test) {
				String exp = "UPDATE Complaint SET category = ?, issue = ?, Description = ?, cmethod = ?, RequestedBy = ?, Status = ?,Comments = ? WHERE complaintid = ?";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setString(1, c.getCategory());
				ps.setString(2, c.getIssue());
				ps.setString(3, c.getDescription());
				ps.setString(4, c.getCmethod());
				ps.setString(5, c.getRequestedby());
				ps.setString(6, c.getStatus());
				ps.setString(7, c.getComments());
				ps.setInt(8, c.getComplaintid());
				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return false;
		}
	}

	public boolean delete(Complaints c) {
		try {
			if (test) {
				String exp = "DELETE FROM Complaint WHERE Complaintid = ?";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setInt(1, c.getComplaintid());
				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return false;
		}
	}

	public UserDetails login(String username, String password) {
		Statement stmt = null;
		try {
			if (test) {
				c = new Complaints();
				u = new UserDetails();
				stmt = (Statement) con.createStatement();
				String exp = "select username,password,type,firstname,lastname,Position,email,phone from userdetails WHERE username ='"
						+ username + "' and password='" + password + "'";
				ResultSet rs = stmt.executeQuery(exp);
				while (rs.next()) {
					u.setPassword(rs.getString("password"));
					u.setUsername(rs.getString("username"));
					u.setType(rs.getString("type"));
					u.setFirstname(rs.getString("firstname"));
					u.setLastname(rs.getString("lastname"));
					u.setPosition(rs.getString("position"));
					u.setEmail(rs.getString("email"));
					u.setPhone(rs.getString("phone"));
				}
				return u;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

	public Complaints getComplaint(String id) {
		int id1 = Integer.parseInt(id);
		Statement stmt = null;
		boolean found = false;
		try {
			if (test) {
				c = new Complaints();
				u = new UserDetails();
				stmt = (Statement) con.createStatement();
				String exp = "Select complaintid,category,issue,Description,cmethod,RequestedBy,Status,Comments from complaint where complaintid ="
						+ id1;
				ResultSet rs = stmt.executeQuery(exp);
				while (rs.next()) {
					found = true;
					c.setComplaintid(rs.getInt("complaintid"));
					c.setCategory(rs.getString("category"));
					c.setIssue(rs.getString("issue"));
					c.setDescription(rs.getString("Description"));
					c.setCmethod(rs.getString("cmethod"));
					c.setRequestedby(rs.getString("RequestedBy"));
					c.setStatus(rs.getString("Status"));
					c.setComments(rs.getString("Comments"));
				}
				if (found == true)
					return c;
				else
					return null;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

	public ArrayList<Complaints> displayopen(String username) {
		Statement stmt = null;
		try {
			if (test) {
				c = new Complaints();
				u = new UserDetails();
				ArrayList<Complaints> comp = new ArrayList<>();
				stmt = (Statement) con.createStatement();
				String exp = "Select complaintid,category,issue,Description,cmethod,RequestedBy,Status,Comments from complaint where requestedby ='"
						+ username + "'";
				ResultSet rs = stmt.executeQuery(exp);

				while (rs.next()) {
					Complaints c1 = new Complaints();
					c1.setCategory(rs.getString("category"));
					comp.add(c1);
				}

				return comp;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}

	}

	public String display() {
		Statement stmt = null;
		String result = "";
		try {
			if (test) {
				c = new Complaints();
				u = new UserDetails();
				stmt = (Statement) con.createStatement();
				String exp = "Select complaintid,category,issue,Description,cmethod,RequestedBy,Status,Comments from complaint";
				ResultSet rs = stmt.executeQuery(exp);

				while (rs.next()) {
					result += rs.getInt("complaintid") + " ";
					result += rs.getString("category") + " ";
					result += rs.getString("issue") + " ";
					result += rs.getString("Description") + " ";
					result += rs.getString("cmethod") + " ";
					result += rs.getString("RequestedBy") + " ";
					result += rs.getString("Status") + " ";
					result += rs.getString("Comments") + "<html><br></html>";
				}
				return result;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

	public String displayLatest() {
		Statement stmt = null;
		String result = "";
		try {
			if (test) {
				stmt = (Statement) con.createStatement();
				String exp = "SELECT complaintid,category,issue,Description,cmethod,RequestedBy,Status,Comments FROM complaint ORDER BY complaintid DESC LIMIT 1";
				ResultSet rs = stmt.executeQuery(exp);
				while (rs.next()) {
					result += "Compalint Id: ";
					result += rs.getInt("complaintid") + ", ";
					result += "Category: ";
					result += rs.getString("category") + ", ";
					result += "Issue: ";
					result += rs.getString("issue") + ", ";
					result += "Description: ";
					result += rs.getString("Description") + ", ";
					result += "Contact Method: ";
					result += rs.getString("cmethod") + ", ";
					result += "Requested By: ";
					result += rs.getString("RequestedBy") + ", ";
					result += "Status: ";
					result += rs.getString("Status") + ", ";
					result += "Comments: ";
					result += rs.getString("Comments") + ", ";
				}
				System.out.println(result);
				return result;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

	public boolean insertionuser(UserDetails u) {
		try {
			if (test) {
				String exp = "insert into userdetails (userid,username,password,firstname,lastname,position,email,phone,type) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setInt(1, u.getUserid());
				ps.setString(2, u.getUsername());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getFirstname());
				ps.setString(5, u.getLastname());
				ps.setString(6, u.getPosition());
				ps.setString(7, u.getEmail());
				ps.setString(8, u.getPhone());
				ps.setString(9, u.getType());

				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			return false;
		}
	}

	public UserDetails userfind(int userid) {
		Statement stmt = null;
		try {
			if (test) {
				u = new UserDetails();
				stmt = (Statement) con.createStatement();
				String exp = "select * from userdetails WHERE userid =" + userid;
				ResultSet rs = stmt.executeQuery(exp);
				while (rs.next()) {
					u.setUserid(rs.getInt("userid"));
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					u.setFirstname(rs.getString("firstname"));
					u.setLastname(rs.getString("lastname"));
					u.setPosition(rs.getString("position"));
					u.setEmail(rs.getString("email"));
					u.setPhone(rs.getString("phone"));
					u.setType(rs.getString("type"));
				}
				return u;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

	public boolean updateuser(UserDetails u) {
		try {
			if (test) {
				String exp = "UPDATE userdetails SET Username = ?, Password = ?, Firstname = ?, Lastname = ?, Position = ?, email = ?, phone = ?, type = ? WHERE userid = ?";
				PreparedStatement ps = con.prepareStatement(exp);

				ps.setString(1, u.getUsername());
				ps.setString(2, u.getPassword());
				ps.setString(3, u.getFirstname());
				ps.setString(4, u.getLastname());
				ps.setString(5, u.getPosition());
				ps.setString(6, u.getEmail());
				ps.setString(7, u.getPhone());
				ps.setString(8, u.getType());
				ps.setInt(9, u.getUserid());
				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return false;
		}
	}

	public boolean deleteuser(UserDetails u) {
		try {
			if (test) {
				String exp = "DELETE FROM userdetails WHERE userid = ?";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setInt(1, u.getUserid());
				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return false;
		}
	}

	public String displayuser() {
		Statement stmt = null;
		String result = "";
		try {
			if (test) {
				u = new UserDetails();
				stmt = (Statement) con.createStatement();
				String exp = "Select * from userdetails";
				ResultSet rs = stmt.executeQuery(exp);

				while (rs.next()) {
					result += rs.getInt("userid") + " ";
					result += rs.getString("username") + " ";
					result += rs.getString("password") + " ";
					result += rs.getString("firstname") + " ";
					result += rs.getString("lastname") + " ";
					result += rs.getString("position") + " ";
					result += rs.getString("email") + " ";
					result += rs.getString("phone") + " ";
					result += rs.getString("type") + "<html><br></html>";

				}
				return result;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

}
