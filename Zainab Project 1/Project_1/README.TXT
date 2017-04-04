------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Project 1 
PURPOSE OF PROJECT: First Semester Project
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:

This project contains an event driven simulation of customers coming into a store.  Data Structures used: Priority Queue, ArrayList, LinkedList, Queue.
The store operates on a 960 minutes word day.  Customers are allowed to join a line (queue) if the line is under 8*n where n is the number of cashiers in the store.
Otherwise, they are sent away as overflow.  After the simulation, appropriate statistics are calculated, such as waiting time and net profit.  The customers follow
a poisson distribution for their arrivals, and the cashiers serve at a rate that follows the same distribution. 

to run on command line: java ExperimentController
