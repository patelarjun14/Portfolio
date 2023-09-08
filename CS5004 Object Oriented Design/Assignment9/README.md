# Assignment 9

Refer to Canvas for assignment due dates for your section.

## Objectives:
- Refactor earlier work to improve modularity.
- Design a solution with MV* architecture.
- Develop sortable custom objects.
- Use design patterns to solve common problems.

## General Requirements
- Create a new Gradle project for this assignment in your group GitHub repo.
- For this assignment, please continue to use packages as in the past. There is only one problem so you may have only one package, but it can be helpful to create additional packages to keep your code organized. The requirements for repository contents are the same as in previous assignments.
- **New:** Please include a brief write-up of which design pattern(s) you used, where, and why. This is just to help your grader understand your approach.

## GitHub and Branches
- Each individual group member should create their own branch while working on this assignment. Only merge to the master branch when you’re confident that your code is working well. You may submit pull requests and merge to master as often as you like. Guidelines on working with branches are available from the assignment page in Canvas.
- To submit your work, push it to GitHub and create a release on your master branch. Only one person needs to create the release.

## The problem: TODO application
For this assignment, you may reuse any relevant code for command-line parsing and file reading/writing from Assignment 8. If your design for Assignment 8 was sufficiently modular, you should find you can re-use some of your classes for this portion of the assignment with little modification. In codewalk, be prepared to talk about how well your original code for command-line parsing and file processing supported extension and reuse. If you have to make substantial changes, be prepared to discuss how you improved your design for this assignment.

### Your task is to build a command-line TODO application. The system will allow a user to add and track the status of their TODOs by due date, category, priority, and status (complete/incomplete).
The application stores all TODOs in a CSV file. The CSV file is a plain text file, containing data organized into columns separated by a comma. The data in each column is enclosed in double quotes. The first line of the file contains the headers for each column.

#### The CSV has 6 columns named id, text, completed, due, priority, and category. You can assume that the CSV column names will not change.

“id”,”text”,”completed”,”due”,”priority”,”category”
"1","Finish HW9","false","4/26/2022","1","school"
"2","Mail passport application, photo","true","5/31/2022","?","?"

The information in each column is enclosed in double quotes. It is possible that column entries may contain a comma. For example, on row 3 in the listing above, “Mail passport application, photo” is one valid piece of information, not two.

Some columns are considered optional and may not contain data. A cell that contains only “?” means that there is no value for this cell (you should not store “?” as a value in your objects). You can see an example on the last line in the listing.

A sample file containing a small number of todos, is available on Canvas, along with these instructions.

### Todo data structure
A Todo consists of the following information:
- text - a description of the task to be done. This field is required.
- completed - indicates whether the task is completed or incomplete. If not specified, this field should be false by default. However, it should be possible to create a new Todo with completed set to true.
- due - a due date. This field is optional.
- priority - an integer indicating the priority of the todo. This field is optional. If the user chooses to specify a priority, it must be between 1 and 3, with 1 being the highest priority. If no priority is specified, the todo can be treated as lowest priority (i.e., 3).
- category - a user-specified String that can be used to group related todos, e.g., “school”, “work”, “home”. This field is optional.

Once a Todo is created, all fields should be immutable, with the exception of completed. In the system, each Todo will also have an integer ID that the user can use to update the completion status of an individual todo (see below). You may choose how and where to generate and track the ID. Generating the ID should not be the user’s responsibility.

### Functionality
The system must support the following functionality:
- Add a new todo. The user must supply the information required by the Todo data structure. They can also choose to specify the optional information. When a new Todo is added, the CSV file should be updated.
- Complete an existing todo. The user set the completed status of an existing Todo to true. When the status is changed, the CSV file should be updated.
- Display todos. The user can request that the program display a list of Todos. You may choose how to format the list, but
