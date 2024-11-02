<!-- Add -->
<div class="modal fade" id="addnew">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title"><b>Add New Past Paper</b></h4>
            </div>
            <div class="modal-body">
              <form class="form-horizontal" method="POST" action="past_add.php" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="code" class="col-sm-3 control-label">Code</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="code" name="code" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">Title</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="title" name="title" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="year" class="col-sm-3 control-label">Year</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="year" name="year" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="semester" class="col-sm-3 control-label">Semester</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="semester" name="semester" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="pdf" class="col-sm-3 control-label">Pdf File</label>

                    <div class="col-sm-9">
                      <input type="file" class="form-control" id="pdf" name="pdf" required>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
              <button type="submit" class="btn btn-primary btn-flat" name="add"><i class="fa fa-save"></i> Save</button>
              </form>
            </div>
        </div>
    </div>
</div>

<!-- Edit -->
<div class="modal fade" id="edit">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title"><b>Edit Course</b></h4>
            </div>
            <div class="modal-body">
              <form class="form-horizontal" method="POST" action="past_edit.php" enctype="multipart/form-data">
                <input type="hidden" class="corid" name="id">
                <div class="form-group">
                    <label for="edit_code" class="col-sm-3 control-label">Code</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="edit_code_id" name="code_id">
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit_title" class="col-sm-3 control-label">Title</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="edit_title_name" name="title_name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit_year" class="col-sm-3 control-label">Year</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="edit_year" name="year">
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit_semester" class="col-sm-3 control-label">Semester</label>

                    <div class="col-sm-9">
                      <input type="text" class="form-control" id="edit_semester" name="semester">
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit_pdf" class="col-sm-3 control-label">Pdf File</label>

                    <div class="col-sm-9">
                      <input type="file" class="form-control" id="edit_pdf" name="pdf">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
              <button type="submit" class="btn btn-success btn-flat" name="edit"><i class="fa fa-check-square-o"></i> Update</button>
              </form>
            </div>
        </div>
    </div>
</div>

<!-- Delete -->
<div class="modal fade" id="delete">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title"><b>Deleting...</b></h4>
            </div>
            <div class="modal-body">
              <form class="form-horizontal" method="POST" action="past_delete.php">
                <input type="hidden" class="corid" name="id">
                <div class="text-center">
                    <p>DELETE PAST PAPER</p>
                    <h2 id="del_id" class="bold"></h2>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
              <button type="submit" class="btn btn-danger btn-flat" name="delete"><i class="fa fa-trash"></i> Delete</button>
              </form>
            </div>
        </div>
    </div>
</div>


     