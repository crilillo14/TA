import os
import subprocess
import shutil
import time
from TextToPdf import write_simple_pdf


students = [line.strip().split(',') for line in open(
	'/Users/CristobalLillo_1/TA/csc220-names.csv')]

distadd = "/Users/CristobalLillo_1/Library/CloudStorage/Box-Box/"
assignment = "Lab06"
assignmentfiles = ["AnagramUtil.java"]
disk_main_add = "/Users/CristobalLillo_1/TA/fall2024/lab06/"
compile_files = ["AnagramUtil.java"]
main_file = "CheckLab.java"
main_class = "CheckLab"
actual_point = [15, 5, 10, 5, 10, 10, 15, 15, 15]


def check_correct_assignment_submission(distadd, assignment, filelist):
	"""
	if the student does not have all assignment files in
	the Box folder, this is an incorrect submission.
	"""
	num_correct_files = 0

	for assign in assignmentfiles:
		# print distadd+"/"+assignment+"/src/"+assignment+"/"+assign
		if os.path.isfile(distadd + "/" + assignment + "/src/" + assignment + "/" + assign) is False:
			# print distadd+"/"+assignment+"/src/"+assignment+"/"+assign
			return (False, num_correct_files)
		else:
			num_correct_files += 1

	return (True, num_correct_files)


def check_shared_folder(distadd, assignment, assignmentfiles):
	"""
	traverse through the csc220 enrollment file and check to see if there
	are any students that don't have a shared Box folder or if there exists a folder,
	but it is incorrectly formatted.
	"""
	folders = os.listdir(distadd)
	# students.sort()
	missing_student = []
	incorrect_student = []
	num_correct_submissions = 0
	for student in students:
		if "csc220-" + student[0] not in folders:
			# this student does not have a Box folder
			missing_student.append(student)
		(has_files, num_files) = check_correct_assignment_submission(distadd + "csc220-" + student[0], assignment, assignmentfiles)
		if has_files is False:
			# this student does not have all required files for the assignment
			incorrect_student.append(student)
		if has_files is True:
			num_correct_submissions += 1

	file = open(disk_main_add + "housekeeping-" +
				assignment.lower() + ".txt", "w")
	file.write("Username, First Name, Last Name\n")
	file.write("\nFolder Missing\n\n")
	for ms in missing_student:
		file.write(ms[0] + ", " + ms[1] + ", " + ms[2] + "\n")
	file.write("\nIncorrect Submission / No Submission\n\n")
	for ms in incorrect_student:
		file.write(ms[0] + ", " + ms[1] + ", " + ms[2] + "\n")
	file.write("\n\n%d correct submissions, %d have not submitted or incorrect, %d total students"
			   % (num_correct_submissions, len(students) - num_correct_submissions, len(students)))
	file.close()


def copy_assignment_with_name(dist_box, dist_disk):
	"""
	copy submissions from Box to local
	"""
	folders = os.listdir(dist_box)
	copied_student = []
	if not os.path.exists(dist_disk):
		os.makedirs(dist_disk)
		print(assignment + " -- Folder created")
	for student in students:
		lab_submit = dist_box + "csc220-" + student[0] + "/" + assignment
		if os.path.exists(lab_submit):
			shutil.copytree(lab_submit, dist_disk +
							"/csc220-" + student[0] + "/" + assignment)
			copied_student.append(student)
			print("Good Submission -- Copied -- " +
				  student[1] + " " + student[2] + " " + student[0])
		else:
			if not os.path.exists(dist_disk + "/csc220-" + student[0]):
				os.makedirs(dist_disk + "/csc220-" + student[0])
			for nfile in assignmentfiles:
				org_loc = find_file(nfile, dist_box + "csc220-" + student[0])
				if org_loc is not None:
					shutil.copyfile(org_loc, dist_disk +
									"/csc220-" + student[0] + "/" + nfile)
			copied_student.append(student)
			print("Bad Submission -- Copied -- " +
				  student[1] + " " + student[2] + " " + student[0])

	file = open(dist_disk + "/wednesday10am.txt", "w")
	for ms in copied_student:
		file.write(ms[0].strip() + "\n")
	file.close()


def assignment_checking_comments(filename, comments):
	"""
	append a comment to the student file
	"""
	file = open(filename, "a+")
	file.write(comments)
	file.write("\n")
	file.close()


def init_comment_file(filename, student):
	"""
	initializes a comment file for the student. specifically, a
	writeable file is created with a header consisting of csc220 username,
	last name, and first name
	"""
	file = open(filename, "w")
	file.write('%-20s %s %s\n\n' % (student[0], student[1], student[2]))
	file.close()


def assignment_checking_rubric(filename, points, status, is_late=False):
	"""
	based on the grade distribution, assign points to a file
	"""
	file = open(filename, "a+")
	file.write("Grading Rubric: \n\n")
	i = 0
	for st in status:
		file.write('%-30s %2s/%2s\n' %
				   (st, str(points[i]), str(actual_point[i])))
		i += 1
	if is_late:
		# file.write("Lateness - "+str(sum(points)*.5)+"%\n");
		file.write('%-30s -%s\n', "Lateness", str(sum(points) * .5))
		file.write("\nSCORE    " + str(sum(points) * 0.5) + " / " + "100\n")
	else:
		file.write("\nSCORE    " + str(sum(points)) + " / " + "100\n")
	file.write("\n")
	file.close()


def find_file(name, path):
	for root, dirs, files in os.walk(path):
		if name in files:
			return os.path.join(root, name)
	return None


def create_copy_the_file_in_correct_order(stu_lab_loc):
	"""
	for students with wrong assignment submission, we need to re-order the
	directories for grading purposes. this is accomplished by adding a TA
	folder to the root of their Box folder.
	"""
	if not os.path.exists(stu_lab_loc + "/TA"):
		os.makedirs(stu_lab_loc + "/TA")
	if not os.path.exists(stu_lab_loc + "/TA/" + assignment):
		os.makedirs(stu_lab_loc + "/TA/" + assignment)
	if not os.path.exists(stu_lab_loc + "/TA/" + assignment + "/src"):
		os.makedirs(stu_lab_loc + "/TA/" + assignment + "/src")
	if not os.path.exists(stu_lab_loc + "/TA/" + assignment + "/src/" + assignment.lower()):
		os.makedirs(stu_lab_loc + "/TA/" + assignment +
					"/src/" + assignment.lower())

	final_loc = stu_lab_loc + "/TA/" + assignment + "/src/" + assignment.lower()
	for nfile in assignmentfiles:
		org_loc = find_file(nfile, stu_lab_loc)
		# student doesn't have a single java file in the folder;
		# something else is in there
		if org_loc is None:
			return False
		else:
			shutil.copyfile(org_loc, final_loc + "/" + nfile)
	return True


def copy_a_backup_copy(disk_destination):
	if os.path.exists(disk_destination + "_Copy") is False:
		shutil.copytree(disk_destination, disk_destination + "_Copy")


def copy_a_backup_copy_original(disk_destination):
	if os.path.exists(disk_destination + "_Copy_Original") is False:
		shutil.copytree(disk_destination, disk_destination + "_Copy_Original")


def assignment_checking_rubric_all(filename, student=None, points=None, is_late=False):

	if points is None:
		file = open(filename, "w")
		file.write("Last Name, First Name, Lab ID, Submitted, Correct Submission, " +
				   "Compiles, Runs, sort(), areAnagrams(), insertionSort()," +
				   "getLargestAnagramGroup(file), getLargestAnagramGroup([]), Signature Penalty, Total")
	else:
		file = open(filename, "a+")
		file.write(student[2] + "," + student[1] + "," + student[0] + ",")
		for pt in points:
			file.write(str(pt) + ",")
		# manually check for signature penalty 
		file.write("-0,")
		# total percent
		file.write(str(sum(points)))
	file.write("\n")
	file.close()


def check_if_actually_not_submitted(dist_disk_loc):
	"""
	verify that the student has not submitted any work
	"""
	for nfile in assignmentfiles:
		org_loc = find_file(nfile, dist_disk_loc)
		if org_loc is not None:
			return False   # found so false
	return True            # not found any so true


def check_assignment_for_student(dist_disk):
	"""
	submitted(15 points)
	correct submission(5 points)
	compile(10 points)
	run(5 points)
	sort(10 points)
	areAnagrams(10 points)
	insertionSort(15 points)
	getLargestAnagramGroup(file) (15 points)
	getLargestAnagramGroup([]) (15 points)
	"""
	copy_a_backup_copy(dist_disk)

	folders = os.listdir(dist_disk)
	submission_missing = []
	submission_wrong = []

	submission_status = ["Submitted", "Correct Submission", "Compiles",
						 "Runs", "sort()", "areAnagrams()", "insertionSort()",
						 "getLargestAnagramGroup(file)", "getLargestAnagramGroup([])"]

	review_file = assignment.lower() + "_comments.txt"
	rubric_all_file = dist_disk + "/" + assignment.lower() + "_rubric.csv"
	# creates the header for rubric file
	assignment_checking_rubric_all(rubric_all_file)
	for student in students:
		print("Checking now for " + student[1] + " " + student[2])
		is_late = False
		submission_point = []
		# initialize the student's grades to 0 using the global grade rubric
		for i in range(0, len(actual_point)):
			submission_point.append(0)
		stu_lab_folder = "csc220-" + student[0]
		stu_lab_comment = dist_disk + "/" + stu_lab_folder + \
			"/" + student[0] + "_" + review_file
		stu_lab_file_loc = dist_disk + "/" + stu_lab_folder
		is_copy = True  # if T, all files are correctly there
		no_submission = False
		init_comment_file(stu_lab_comment, student)
		assignment_checking_comments(stu_lab_comment, "\nComments:\n")
		(correct_submission, num_files) = check_correct_assignment_submission(
			stu_lab_file_loc, assignment, assignmentfiles)

		if stu_lab_folder not in folders or check_if_actually_not_submitted(stu_lab_file_loc):
			submission_missing.append(student)
			if stu_lab_folder not in folders:
				os.makedirs(stu_lab_file_loc)
			# add a comment why he is getting a 0
			assignment_checking_comments(
				stu_lab_comment, "No assignment submitted.\n")
			is_copy = False
			no_submission = True
		elif correct_submission is False:
			# incorrect submission, but he submitted so he gets submission
			# points
			submission_point[0] = actual_point[0]
			submission_wrong.append(student)
			# if no correct files were found in the directory, then the student likely
			# has an incorrect format for his submission
			if num_files == 0:
				assignment_checking_comments(
					stu_lab_comment, "Assignment submission is in improper format.\n")
			# create the correct package for him inside a folder called TA
			is_copy = create_copy_the_file_in_correct_order(stu_lab_file_loc)
			stu_lab_file_loc = stu_lab_file_loc + "/TA"
		else:
			# these are the good guys; they did it right
			submission_point[0] = actual_point[0]  # assignment submitted
			# assignment submitted correctly
			submission_point[1] = actual_point[1]

		# now compile and run

		if is_copy:
			source_folder = stu_lab_file_loc + "/" + assignment + "/src/"
			package_folder = stu_lab_file_loc + "/" + \
				assignment + "/src/" + assignment.lower()
			# copy my CheckLab.java into each of the student's lab folder
			src_main = "/Users/CristobalLillo_1/TA/csc220-scripts_Automated_Grading_fromJerry/csc220-scripts/java/src/" + assignment.lower() + \
				"/" + main_file
			shutil.copyfile(src_main, package_folder + "/" + main_file)
   
			# this might not work, but importing the other classes into the angaramutil.java file
   
			add_imports_to_anagram_util(package_folder)

			# now compile
			javac_command = package_folder + "/" + main_file
			for cname in compile_files:
				javac_command += " " + package_folder + "/" + cname

			# check to see if OrderStrings is present
			if os.path.exists(package_folder + "/OrderStrings.java"):
				javac_command += " " + package_folder + "/OrderStrings.java"


			javac_command = "javac " + javac_command
			# print javac_command
			compile = os.popen(javac_command)
			output = compile.read()
			is_compiled = compile.close()
			output = "-1"
			is_run_successfully = 1
			# now run
			if is_compiled is None:
				submission_point[2] = actual_point[2]   # program compiled successfully
				java_run = "java -cp " + source_folder + " " + assignment.lower() + "." + main_class
				# print java_run
				run = os.popen(java_run)
				output = run.read()
				is_run_successfully = run.close()
				# here i get: $$5.0$$5.0$$12.5$$12.5$$12.5$$12.5$$
				output = output.strip()
			else:
				assignment_checking_comments(stu_lab_comment, "Does not compile.\n")
				# tell me list of students that had compiler errors
				submission_wrong.append(student)
				
			if is_run_successfully is None:
				# add points for successful run
				submission_point[3] = actual_point[3]  # program run successfully
			elif is_compiled is None:
				# runtime error
				assignment_checking_comments(stu_lab_comment, "Program has runtime error.\n")

			if is_compiled is None and is_run_successfully is None:
				message = output[output.index("$$") + 2:output.rindex("$$")].split("$$")
				comments = output[output.rindex("$$") + 2:]
				# get the grades
				for i in range(0, len(message)):
					submission_point[i + 4] = int(round(float(message[i])))

				assignment_checking_comments(stu_lab_comment, comments + "\n")

		elif no_submission is False:
			assignment_checking_comments(
				stu_lab_comment, "Your submission is incorrect. You may not have submitted all required files.\n")
			assignment_checking_comments(
				stu_lab_comment, "Does your folder have? " + compile_files[0] + "\n")
		assignment_checking_rubric(
			stu_lab_comment, submission_point, submission_status, is_late)
		assignment_checking_rubric_all(
			rubric_all_file, student, submission_point, is_late)
		print(student[1] + " " + student[2] + " done")

	file = open(dist_disk + "/double_check.txt", "w")
	file.write("Username, First Name, Last Name\n")
	for student in submission_wrong:
		file.write(student[0] + ", " + student[1] + ", " + student[2] + "\n")
	file.close()


# this function will add the necessary imports to the AnagramUtil.java file
# added by some TA trying to fix the issue, not by professor
def add_imports_to_anagram_util(package_folder):
    # find the AnagramUtil.java file
    # add the imports to it
    # this is a hack to fix the issue
    # this is not the best way to do this
    # but it works

    anagram_util_file = os.path.join(package_folder, "AnagramUtil.java")
    imports = """\
import lab06.InsertionSort;
import lab06.SortedString;
import lab06.MergeSort;
"""

    # Check if AnagramUtil.java exists
    if os.path.exists(anagram_util_file):
        print(f"Adding imports to {anagram_util_file}")
        # Read the existing content
        with open(anagram_util_file, 'r') as file:
            content = file.read()

        # Prepend the import statements if not already present
        if not content.startswith(imports):
            content = imports + content

            # Write the updated content back to the file
            with open(anagram_util_file, 'w') as file:
                file.write(content)
                print(f"Added imports to {anagram_util_file}")








def check_wrong_package_name(dist_disk):
	"""
	this test checks to see if student folders model the proper format for submission. 
	Submissions should follow the format: 
	csc220-xxx220 > Lab01 > src > lab01

	students that fail to meet this order will have their account written to the file
	wrong_package_name.txt
	"""
	copy_a_backup_copy_original(dist_disk)
	submission_wrong = []
	# students.sort()
	for student in students:
		stu_lab_folder = "csc220-" + student[0]
		stu_lab_file_loc = dist_disk + "/" + stu_lab_folder
		for nfile in assignmentfiles:
			org_loc = find_file(nfile, stu_lab_file_loc)
			if org_loc is not None:
				code_file = open(org_loc, "r")
				whole_code = code_file.read()
				code_file.close()
				# look for "package lab01;" on top of java file
				if(whole_code.find(assignment.lower() + ";")) == -1:
					submission_wrong.append(student)
					break
	file = open(dist_disk + "/wrong_package_name.txt", "w")
	file.write("Username, First Name, Last Name\n")
	for ms in submission_wrong:
		file.write(ms[0] + ", " + ms[1] + ", " + ms[2] + "\n")
	file.close()


def submit_grade_in_box(dist_disk, box_add):
	# students.sort()
	for student in students:
		review_file = student[0] + "_" + assignment.lower() + "_comments"
		disk_stu_lab_comment = dist_disk + "/" + "csc220-" + student[0]
		box_stu_lab_comment = box_add + "csc220-" + student[0]
		# shutil.copyfile(disk_main_add + "txt2pdf.py", disk_stu_lab_comment + "/" + "txt2pdf.py")
		python_run = "python " + disk_main_add + "txt2pdf.py" + " -qo " \
			+ disk_stu_lab_comment + "/" + review_file + ".pdf" + " " \
			+ disk_stu_lab_comment + "/" + review_file + ".txt"
		run = os.popen(python_run)
		# make the pdf
		# write_simple_pdf(disk_stu_lab_comment,review_file)
		# uploads the pdf file to the student's box account
		time.sleep(1)
		shutil.copyfile(disk_stu_lab_comment+"/"+review_file+".pdf",box_stu_lab_comment+"/"+review_file+".pdf");
		print("uploaded for " + student[1] + " " + student[2])


def does_pdf_exist(dist_disk, box_add):
	for student in students:
		review_file = student[0] + "_" + assignment.lower() + "_comments"
		disk_stu_lab_comment = dist_disk + "/" + "csc220-" + student[0]
		box_stu_lab_comment = box_add + "csc220-" + student[0]
		if (os.path.isfile(box_stu_lab_comment + "/" + review_file + ".pdf") 
			and os.path.getsize(box_stu_lab_comment + "/" + review_file + ".pdf") > 0):
			print(student[0] + "-- pdf exists")
		else:
			print(student[0] + "-- pdf does NOT exist")

# comment and uncomment each as you grade; don't uncomment all at once
# first - just a check; no copying
# check_shared_folder(distadd,assignment,assignmentfiles)

# second
# copy_assignment_with_name(distadd, disk_main_add+assignment);

# third
# check_wrong_package_name(disk_main_add+assignment)

# fourth
check_assignment_for_student(disk_main_add + assignment)

# fifth - put grade
#submit_grade_in_box(disk_main_add+assignment,distadd);

# sixth - verify pdf was uploaded
# does_pdf_exist(disk_main_add+assignment,distadd)
